package com.ef;

import org.apache.log4j.Logger;

public class Local {

	public static Logger log = Logger.getLogger(Local.class);
	
	// testar localmente
	public static void main(String[] args) {

		try {
			
			String[] springConfig = { "classpath:config/config.xml"
									, "ParserJob"
									, "accesslog=c:/teste"
									, "startDate=2017-01-01.00:00:00"
									, "endDate=2017-01-01.23:59:59"
									, "threshold=5"};
			
			org.springframework.batch.core.launch.support.CommandLineJobRunner.main(springConfig);

		} catch (Exception e) {
			log.error(e);
		}

	}
}
