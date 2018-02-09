package com.ef;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Parser {

	public static Logger log = Logger.getLogger(Parser.class);
	
	// testar localmente
	public static void main(String[] args) {

		try {
			
			if (args == null || args.length == 0){
				log.error("No args");
				System.exit(1);
			}
			
			String appName = "ParserJob";
			String accesslog = null;
			String startDateString = null;
			Date startDate = null;
			String endDateString = null;
			Date endDate = null;
			String duration = null;
			String threshold = null;
			
			// setting args -- begin
			for(String arg: args){
				String[] tmp = arg.split("=");
				switch(tmp[0]){
				case "accesslog":
					accesslog = tmp[1];
					break;
				case "startDate":
					startDateString = tmp[1];
					break;
				case "duration":
					duration = tmp[1];
					break;
				case "threshold":
					threshold = tmp[1];
					break;
				default:
					log.warn("Invalid Parameter: " + arg);
				}
			}
			// setting args -- end
			
			// validating Start Date and End Date -- begin
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
			startDate = formatter.parse(startDateString);
			
			switch(duration){
				case "hourly":
				// Java 8
				//endDate = startDate.toInstant().plus(1,ChronoUnit.HOURS); // it has to change datatype
				endDate = new Date(startDate.getTime() + (1000 * 60 * 60));
				break;
				case "daily":
				// Java 8
				//endDate = startDate.toInstant().plus(1,ChronoUnit.DAYS); // it has to change datatype
				endDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24));
				break;
				default:
					log.error("Invalid Parameter duration: "+duration);
					System.exit(1);
			}
			
			// convert to String
			endDateString = formatter.format(endDate);
			// validating Start Date and End Date -- end			
			
			String[] springConfig = { "classpath:config/config.xml"
					, appName
					, "accesslog="+accesslog
					, "startDate="+startDateString
					, "endDate="+endDateString
					, "threshold="+threshold};

			org.springframework.batch.core.launch.support.CommandLineJobRunner.main(springConfig);
			

		} catch (Exception e) {
			log.error(e);
		}

	}

}
