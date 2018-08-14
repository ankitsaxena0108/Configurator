package com.prudential.core.common.configuration.camelconfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.common.properties.RouteConfigProperties;

public class CBISourceOutFileName implements Processor {

	private String systemName;
	private RouteConfigProperties properties = new RouteConfigProperties();

	public CBISourceOutFileName(String systemName) {
		this.systemName = systemName;
	}

	@Override
	public void process(Exchange exchange) throws Exception {

		List<BankTxnRecord> records = exchange.getIn().getBody(List.class);
		List<String> sourceRecords = new ArrayList<String>();
		String dateFormat = properties.get("RESPONSEFILE_DATE_FORMAT");

		DateFormat df = new SimpleDateFormat(dateFormat);
		Calendar cal = Calendar.getInstance();

		exchange.getOut().setHeader(Exchange.FILE_NAME,
				properties.get(systemName + "_RESPFILENAME") + "_" + df.format(cal.getTime()) + ".txt");

		for (BankTxnRecord value : records) {

			if (value.getSourceDetailRecord() != null && !value.getSourceDetailRecord().toUpperCase().equals("NULL")
					&& !value.getSourceDetailRecord().isEmpty()) {
				sourceRecords.add(value.getSourceDetailRecord());
			}

		}

		exchange.getOut().setBody(sourceRecords);

	}

}
