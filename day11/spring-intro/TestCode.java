package com.cdac.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.HelloWorld;

public class TestCode {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("app-config.xml");
		
		HelloWorld hw = (HelloWorld) context.getBean("hw");
		System.out.println(hw.sayHello("Majrul"));
		
	}
}
