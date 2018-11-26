package com.cdac.dp.ver3;

public abstract class Logger {

	public void log(String msg) {
		log(msg, LogLevel.INFO);
	}
	
	public abstract void log(String msg, LogLevel level);
}
