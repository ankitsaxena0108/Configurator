package com.prudential.core.common.configuration.camelconfiguration;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;

public class CBIFileTransferRouteBuilder extends RouteBuilder{

	
	private String systemName;
	private String category;
	private String paymentType;
	private String sourceFeedPolling;
	private String rootPath;

	
	private static final Logger logger = LoggerFactory.getLogger(CBIFileTransferRouteBuilder.class);
	

	public CBIFileTransferRouteBuilder(String systemName, String category, String paymentType,
			String sourceFeedPolling, String rootPath) {
		super();
		this.systemName = systemName;
		this.category = category;
		this.paymentType = paymentType;
		this.sourceFeedPolling = sourceFeedPolling;
		this.rootPath = rootPath;
	}
	
	
	
	@Override
	public void configure() throws Exception {
		
		//based on the config we have to put SFTP/FTP routes
		
		 onException(Exception.class)
		 .handled(true)
	     .log("Moved file ${file:name} to Exception Folder");
		
		from(CBIRouteUtils.getFileRouteID(rootPath,systemName,null)+"&move=.completed&moveFailed=Exception").routeId(systemName+"Transfer")
		
		.to(CBIRouteUtils.getFileRouteID(rootPath,systemName + "/Staging",null) + "&doneFileName="+systemName+".done")
		
		.end();
		
		
	}



}
