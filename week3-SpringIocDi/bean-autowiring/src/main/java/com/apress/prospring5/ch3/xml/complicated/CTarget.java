package com.apress.prospring5.ch3.xml.complicated;

import com.apress.prospring5.ch3.xml.Bar;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 2/24/17.
 */
public class CTarget {
	private static final Logger logger = 
		LoggerFactory.getLogger(CTarget.class);
		
	private Foo fooOne;
	private Foo fooTwo;
	private Bar bar;

	public CTarget() {
	}

	public CTarget(Foo foo) {
		logger.info("Target(Foo) called");
	}

	public CTarget(com.apress.prospring5.ch3.xml.Foo foo, Bar bar) {
		logger.info("Target(Foo, Bar) called");
	}

	public void setFooOne(Foo fooOne) {
		this.fooOne = fooOne;
		logger.info("Property fooOne set");
	}

	public void setFooTwo(Foo foo) {
		this.fooTwo = foo;
		logger.info("Property fooTwo set");
	}

	public void setBar(Bar bar) {
		this.bar = bar;
		logger.info("Property bar set");
	}

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//using primary
		ctx.load("classpath:spring/app-context-04.xml");

		ctx.refresh();
		logger.info("\nUsing byType:\n");
		CTarget t = (CTarget) ctx.getBean("targetByType");
		ctx.close();
	}
}