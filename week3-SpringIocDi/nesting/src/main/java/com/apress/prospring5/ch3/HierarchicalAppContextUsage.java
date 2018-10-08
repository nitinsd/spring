package com.apress.prospring5.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HierarchicalAppContextUsage {
	private static final Logger logger = 
			LoggerFactory.getLogger(HierarchicalAppContextUsage.class);
			
	public static void main(String... args) {	
		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("classpath:spring/parent-context.xml");
		parent.refresh();

		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("classpath:spring/child-context.xml");
		child.setParent(parent);
		child.refresh();

		Song song1 = (Song) child.getBean("song1");
		Song song2 = (Song) child.getBean("song2");
		Song song3 = (Song) child.getBean("song3");

		logger.info("from parent ctx: " + song1.getTitle());
		logger.info("from child ctx: " + song2.getTitle());
		logger.info("from parent ctx: " + song3.getTitle());

		child.close();
		parent.close();
	}
}
