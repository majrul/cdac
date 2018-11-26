package com.cdac.dp.ver2;

import java.util.Date;

/**
 * Requirement is to develop logging functionality in Java
 * 
 * @author Majrul Ansari
 * @version 2.0
 *
 */
public class ConsoleLogger {

	public void log(String msg) {
		//System.out.println("[INFO] [" + new Date() + "] " + msg);
		log(msg, LogLevel.INFO);
	}
	
	public void log(String msg, LogLevel level) {
		switch (level) {
		case INFO:
			System.out.println("[INFO] [" + new Date() + "] " + msg);
			break;
		case WARN:
			System.out.println("[WARNING] [" + new Date() + "] " + msg);
			break;
		case DEBUG:
			System.out.println("[DEBUG] [" + new Date() + "] " + msg);
			break;
		case ERROR:
			System.out.println("[ERROR] [" + new Date() + "] " + msg);
		}
	}
}




