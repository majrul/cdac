package com.cdac.dp.ver1;

public class TestLogger {

	public static void main(String[] args) {
		Logger l = new Logger();
		l.log("Some message", LogLevel.ERROR);
		l.log("Again some message");
	}
}
