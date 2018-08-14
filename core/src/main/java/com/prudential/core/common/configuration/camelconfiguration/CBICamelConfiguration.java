package com.prudential.core.common.configuration.camelconfiguration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jpa.JpaComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.configurations.BankConfig;
import com.prudential.core.cbi.configurations.CommonBankingInterfaceConfig;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.model.CBIConfig;
import com.prudential.core.cbi.scheduleInfo.OtherConfig;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.cbi.sourcesystem.SourceSystemConfig;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.configuration.excel.EndpointConfig;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfig;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfigurator;

public class CBICamelConfiguration {

	private JpaComponent jpaComponent;

	private CamelContext camelContext = null;
	private Boolean started = false;
	
	private static final Logger logger = LoggerFactory.getLogger(CBICamelConfiguration.class);

	public Boolean getStarted() {
		return started;
	}



	@Autowired
	private CBIConfigService cbiConfigService;
	
	@Autowired
	private FileAuditDAO auditDao;

	/**
	 * 
	 * @param jpaComponent
	 */
	public CBICamelConfiguration(JpaComponent jpaComponent) {
		this.jpaComponent = jpaComponent;

	}

	@PostConstruct
	public void init() throws Exception {
		start();
	}

	/**
	 * 
	 * @throws Exception
	 */

	public void start() throws Exception {
		this.camelContext = new DefaultCamelContext();
		setupCamelContext(camelContext);
		camelContext.start();
		started = Boolean.TRUE;

	}

	
	
	/**
	 * @param systemName
	 * @throws Exception
	 */
	public void startRoute(String systemName) throws Exception {

		
		ProducerTemplate template = camelContext.createProducerTemplate();
		 template.requestBodyAndHeader("direct:"+systemName+"0", "","","" );

	}
	
	
	/**
	 * @param camelContext
	 * @throws Exception
	 */
	protected void setupCamelContext(CamelContext camelContext) throws Exception {

		this.camelContext = camelContext;
		camelContext.addComponent("jpa", jpaComponent);

		Iterable<CBIConfig> configValues = cbiConfigService.findAllConfig();
		
		if(configValues==null)
			return;

		for (CBIConfig record : configValues)

		{
			CBIProcessFlowConfig config = new CBIProcessFlowConfig();

			// put Code to Fetch CBIConfig based on Category
			// Code to fetch available Categories

			CBIConfig configExcel = cbiConfigService.findCBIConfigByCategory(record.getCategory());

			if (configExcel == null)
				return;

			ByteArrayInputStream is;
			is = new ByteArrayInputStream(configExcel.getConfigBlob());

			BankFeedConfigurator value = BankFeedConfigurator.from(is);

			Map<String, List> systemList = CBIRouteUtils.getListOfSystems(value.getConfig());

			Map<String, String> cronExpressionMap = CBIRouteUtils.getCronExpression(configExcel.getScheduleInfo(),
					systemList);
			//not used so commented
			//Map<String,OtherConfig> bankOtherConfig = CBIRouteUtils.getOtherConfig(configExcel.getOtherConfig(), systemList);

			CommonBankingInterfaceConfig cbiConfig = config.getConfigurations(systemList, cronExpressionMap);

			for (SourceSystemConfig sourceConfig : cbiConfig.getSourceSystems()) {

				is = new ByteArrayInputStream(configExcel.getConfigBlob());

				for (RouteBuilder builder : getSourceRouteBuilder(is, cbiConfig, sourceConfig))
					camelContext.addRoutes(builder);
			}

			is = new ByteArrayInputStream(configExcel.getConfigBlob());
			BankFeedConfigurator configurator = BankFeedConfigurator.from(is);

			for (BankConfig bankConfig : cbiConfig.getBanks()) {

				is = new ByteArrayInputStream(configExcel.getConfigBlob());

				for (RouteBuilder builder : getBankRouteBuilder(configurator, bankConfig, cbiConfig, is)) {
					camelContext.addRoutes(builder);
				}
			}

		}
	}

	public void stop() throws Exception {

		this.camelContext.stop();
		started = Boolean.FALSE;

	}

	
	
	
	
	/**
	 * @param is
	 * @param cbiConfig
	 * @param sourceConfig
	 * @return
	 */
	private List<RouteBuilder> getSourceRouteBuilder(InputStream is, CommonBankingInterfaceConfig cbiConfig,
			SourceSystemConfig sourceConfig) {

		String systemName;
		String sourceFeedPolling = null;
		String sourceInwardPath;
		String sourceOutwardPath;

		List<RouteBuilder> routes = new ArrayList<>();

		sourceInwardPath = cbiConfig.getSourceInwardRootFolder();

		sourceOutwardPath = cbiConfig.getSourceOutwardRootFolder();

		sourceFeedPolling = cbiConfig.getSourceFeedProcessingPollingInterval();
		systemName = sourceConfig.getSourceSystemName();
		
		boolean isBiroOrEbanking = false;

		if(systemName.toUpperCase().contains("BIRO") || systemName.toUpperCase().contains("EBANK"))	
		{
			isBiroOrEbanking = true;
		}
		
		//Inward route not to be configured for BIRO and EBanking
		
		if(!isBiroOrEbanking)
		{
		CBIFileTransferRouteBuilder transferBuilder = new CBIFileTransferRouteBuilder(systemName,
				sourceConfig.getCategory(), sourceConfig.getCategory(), sourceFeedPolling, sourceInwardPath);

		CBISourceInRouteBuilder inwardBuilder = new CBISourceInRouteBuilder(systemName, sourceConfig.getCategory(),
				sourceConfig.getPaymentType(), sourceFeedPolling, is, sourceInwardPath,auditDao , cbiConfigService);
		
		routes.add(transferBuilder);
		routes.add(inwardBuilder);
		}

		
		CBISourceOutRouteBuilder outwardBuilder = new CBISourceOutRouteBuilder(systemName, sourceOutwardPath,
				sourceConfig.getCategory(), sourceConfig.getPaymentType(), sourceConfig.getCronConfig(),
				cbiConfigService,auditDao);

		
		routes.add(outwardBuilder);

		return routes;
	}

	
	
	/**
	 * @param configurator
	 * @param bankConfig
	 * @param cbiConfig
	 * @param is
	 * @return
	 */
	private List<RouteBuilder> getBankRouteBuilder(BankFeedConfigurator configurator, BankConfig bankConfig,
			CommonBankingInterfaceConfig cbiConfig,InputStream is) {

		List<RouteBuilder> routes = new ArrayList<>();
		
		
		String bankInwardPath;
		String bankOutwardPath;
		
		String systemName = bankConfig.getBankCode();
		
		boolean isBiroOrEbanking = false;

		if(systemName.toUpperCase().contains("BIRO") || systemName.toUpperCase().contains("EBANK"))	
		{
			isBiroOrEbanking = true;
		}
		
		bankInwardPath = cbiConfig.getBankInwardRootFolder();
		
		bankOutwardPath = cbiConfig.getBankOutwardRootFolder();

		Integer batchSize = CBIRouteUtils.getBatchSize(configurator.getConfig(), bankConfig.getBankCode());

		logger.info("Batch Size For "+bankConfig.getBankCode()+ " is " +batchSize);
		
		
		String feedPolling = cbiConfig.getBankResponseProcessingPollingInterval();

		String rootPath = cbiConfig.getBankOutwardRootFolder();

		//Outward route not to be configured for BIRO and EBanking
		
		if(!isBiroOrEbanking)
		{
			CBIBankOutRouteBuilder outwardBuilder = new CBIBankOutRouteBuilder(batchSize, bankConfig, BankTxnRecord.State.SOURCE_FEED_PROCESSED.toString(),
					bankOutwardPath, cbiConfigService,auditDao);
			routes.add(outwardBuilder);
		
		}
			
		CBIBankInRouteBuilder inwardBuilder = new CBIBankInRouteBuilder(bankConfig.getBankCode(), bankConfig.getCategory(), bankConfig.getPaymentType()
				, feedPolling,	is, bankInwardPath, cbiConfigService,auditDao);

		CBIFileTransferRouteBuilder transferBuilder = new CBIFileTransferRouteBuilder(bankConfig.getBankCode(),
				bankConfig.getCategory(), bankConfig.getPaymentType(), feedPolling, bankInwardPath);
		
		routes.add(transferBuilder);
		routes.add(inwardBuilder);
		
		

		return routes;
	}



}
