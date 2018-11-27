package com.cdac.dp.ver4;

public class TestLogger {

	public static void main(String[] args) {
		//ConsoleLogger l = new ConsoleLogger();
		//FileLogger l = new FileLogger();
		//Logger l = new ConsoleLogger();
		//Logger l = new FileLogger();
		LoggerFactory lf = new LoggerFactory();
		Logger l = lf.getLoggerInstance();
		l.log("Some serious problem", LogLevel.ERROR);
		l.log("Some info message");
	}
}
