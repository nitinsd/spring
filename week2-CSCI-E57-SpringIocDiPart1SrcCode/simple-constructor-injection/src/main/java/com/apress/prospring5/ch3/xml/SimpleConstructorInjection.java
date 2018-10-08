package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.prospring5.ch3.bean.Student;

public class SimpleConstructorInjection {
	private static final Logger logger = 
			LoggerFactory.getLogger(SimpleConstructorInjection.class);

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml"); // will read xml config, create student bean and inject dependencies
		ctx.refresh(); // will make the student bean active
		
		Student student = (Student) ctx.getBean("student");
		
		logger.info("Constructor Injection student = " + student.toString());
		ctx.close();
	}
}
