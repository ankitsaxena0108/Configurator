package com.prudential.core.common.configuration.camelconfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.prudential.core.cbi.configurations.BankConfig;
import com.prudential.core.cbi.configurations.CommonBankingInterfaceConfig;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.sourcesystem.SourceSystemConfig;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIConstants;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.properties.RouteConfigProperties;

public class CBIProcessFlowConfig {
	
	private RouteConfigProperties properties = new RouteConfigProperties();
	BankTxnRecord txnRecord = new BankTxnRecord();
	
	Map<String, String> cronExpressionMap;
	
	public CommonBankingInterfaceConfig getConfigurations(Map<String,List> systems, Map<String, String> cronExpressionMap)
	
	{
		CommonBankingInterfaceConfig configObj = new CommonBankingInterfaceConfig();
		this.cronExpressionMap = cronExpressionMap;
		
		//to get from properties
		
		configObj.setSourceFeedProcessingPollingInterval(properties.get("source.feed.polling"));
		configObj.setBankResponseProcessingPollingInterval(properties.get("bank.feed.polling"));
		
		configObj.setBankInwardRootFolder(properties.get("bank.inward.root"));
		configObj.setBankOutwardRootFolder(properties.get("bank.outward.root"));
		
		configObj.setSourceOutwardRootFolder(properties.get("source.outward.root"));
		configObj.setSourceInwardRootFolder(properties.get("source.inward.root"));
		
		configObj.setBanks(getBankConfig(systems.get("banks")));
		configObj.setSourceSystems(getSourceSystemConfig(systems.get("sources")));
		return configObj;
	}

	
	
	private List<SourceSystemConfig> getSourceSystemConfig(List<String> sources) {

		List<SourceSystemConfig> list = new ArrayList<SourceSystemConfig>();
		SourceSystemConfig sourceSystemConfig;

		for (String value : sources) {
			sourceSystemConfig = new SourceSystemConfig();
		
			Map<String,String> types= CBIRouteUtils.getCategoryAndPaymentType(value);
			sourceSystemConfig.setCategory(types.get(CBIConstants.CATEGORY_KEY));
			
			sourceSystemConfig.setPaymentType(types.get(CBIConstants.PAYMENT_MODE_KEY));
			
			if (cronExpressionMap.get(value) != null)
				sourceSystemConfig.setCronConfig(cronExpressionMap.get(value));

			else

				sourceSystemConfig.setCronConfig("0+0/1+*+?+*+*");
			
			sourceSystemConfig.setSourceSystemName(value);
			list.add(sourceSystemConfig);
		}

		return list;

	}

	private List<BankConfig> getBankConfig(List<String> banks) {
		
		List<BankConfig> list = new ArrayList<BankConfig>();
		
		for(String value:banks)
		{
			
			BankConfig bankConfig = new BankConfig();
			bankConfig.setBankCode(value);
			Map<String,String> types= CBIRouteUtils.getCategoryAndPaymentType(value);
			bankConfig.setCategory(types.get(CBIConstants.CATEGORY_KEY));
			
			if (cronExpressionMap.get(value) != null)
				
				bankConfig.setCronConfig(cronExpressionMap.get(value));

			else

				bankConfig.setCronConfig("0+0/1+*+?+*+*");
			
			
			
			bankConfig.setPaymentType(types.get(CBIConstants.PAYMENT_MODE_KEY));
			
			list.add(bankConfig);
		
		}
		
		return list;

		
	}

}
