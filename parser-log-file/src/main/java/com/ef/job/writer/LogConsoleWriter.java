package com.ef.job.writer;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import com.ef.db.model.LogFile;

public class LogConsoleWriter implements ItemWriter<LogFile> {

	public static Logger log = Logger.getLogger(LogConsoleWriter.class);

	@Override
	public void write(List<? extends LogFile> logs) throws Exception {
		
		for(LogFile lf: logs){
			log.info(lf.getIp());
		}
		
		
	}
	
		
}
