package com.cdac.dp.ver4;

public class LoggerFactory {

	public Logger getLoggerInstance() {
		return new FileLogger();
	}
}
