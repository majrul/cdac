package com.cdac.dp.ver3;

public class TestLogger {

	public static void main(String[] args) {
		//ConsoleLogger l = new ConsoleLogger();
		//FileLogger l = new FileLogger();
		//Logger l = new ConsoleLogger();
		Logger l = new FileLogger();
		l.log("Some serious problem", LogLevel.ERROR);
		l.log("Some info message");
	}
}
