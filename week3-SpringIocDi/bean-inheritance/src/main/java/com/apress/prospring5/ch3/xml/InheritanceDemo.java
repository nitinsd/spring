package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 2/25/17.
 */
public class InheritanceDemo {
    private static final Logger logger = 
		LoggerFactory.getLogger(InheritanceDemo.class);
		
	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();

		Singer parent = (Singer) ctx.getBean("parent");
		Singer child = (Singer) ctx.getBean("child");

		logger.info("Parent:\n" + parent);
		logger.info("Child:\n" + child);
	}
}

