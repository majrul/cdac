package com.cdac.di.usingspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCode {

	public static void main(String[] args) {
		//loading the IoC Container
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("app-config.xml");

		TextEditor te = (TextEditor) context.getBean("txtEditor");
		te.loadTextFile("abc.txt");
	}
}
