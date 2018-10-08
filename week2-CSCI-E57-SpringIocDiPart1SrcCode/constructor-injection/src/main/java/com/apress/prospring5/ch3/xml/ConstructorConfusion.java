package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConstructorConfusion {
    private static final Logger logger = 
		LoggerFactory.getLogger(ConstructorConfusion.class);
		
	private String someValue;

	public ConstructorConfusion(String someValue) {
		logger.info("ConstructorConfusion(String) called");
		this.someValue = someValue;
	}

	public ConstructorConfusion(int someValue) {
		logger.info("ConstructorConfusion(int) called");
		this.someValue = "Number: " + Integer.toString(someValue);
	}

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
		logger.info("Xml ConstructorConfusion cc = " + cc.toString());
		ctx.close();
	}

	public String toString() {
		return someValue;
	}
}
