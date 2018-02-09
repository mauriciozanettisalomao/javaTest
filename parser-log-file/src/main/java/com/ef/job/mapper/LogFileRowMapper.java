package com.ef.job.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ef.db.model.LogFile;

public class LogFileRowMapper implements RowMapper<LogFile> {

	@Override
	public LogFile mapRow(ResultSet rs, int rowNum) throws SQLException {
		LogFile logFile = new LogFile();
		
		logFile.setDate(rs.getString("date"));
		logFile.setIp(rs.getString("ip"));
		logFile.setRequest(rs.getString("request"));
		logFile.setStatus(rs.getString("status"));
		logFile.setUserAgent(rs.getString("userAgent"));
		logFile.setDescriptionOfBlock(rs.getString("DescriptionOfBlock"));
		
		return logFile;
	}

}
