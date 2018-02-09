package com.ef.job.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import com.ef.db.model.LogFile;
import com.ef.job.writer.LogConsoleWriter;

public class LogFileProcessor implements ItemProcessor<LogFile, LogFile> {

	public static Logger log = Logger.getLogger(LogFileProcessor.class);
	
	public String startDate;
	public String endDate;
	public String threshold;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	@Override
	public LogFile process(LogFile item) throws Exception {
		
		log.info("IP "+item.getIp()+" blocked - threshold: "+this.threshold+"/startDate: "+this.startDate+"/endtDate: "+this.startDate);
		
		return item;
	}

}
