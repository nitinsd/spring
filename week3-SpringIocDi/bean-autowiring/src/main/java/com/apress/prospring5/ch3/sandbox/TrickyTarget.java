package com.apress.prospring5.ch3.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 2/23/17.
 */
@Component("gigi")
@Lazy
public class TrickyTarget {
    private static final Logger logger = 
		LoggerFactory.getLogger(TrickyTarget.class);
		
	Foo fooOne;
	Foo fooTwo;
	Bar bar;

	public TrickyTarget() {
		logger.info("Target.constructor()");
	}

	public TrickyTarget(Foo fooOne) {
		logger.info("Target(Foo) called");
	}

	public TrickyTarget(Foo fooOne, Bar bar) {
		logger.info("Target(Foo, Bar) called");
	}

	// comment @Qualifier annotation to cause NoUniqueBeanDefinitionException being thrown at runtime
	@Autowired
	@Qualifier("fooImplOne")
	public void setFooOne(Foo fooOne) {
		this.fooOne = fooOne;
		logger.info("Property fooOne set");
	}

	// comment @Qualifier annotation to cause NoUniqueBeanDefinitionException being thrown at runtime
	// and make sure for @Primary in FooImpl to be commented as well
	@Autowired
	@Qualifier("fooImplTwo")
	public void setFooTwo(Foo foo) {
		this.fooTwo = foo;
		logger.info("Property fooTwo set");
	}

	@Autowired
	public void setBar(Bar bar) {
		this.bar = bar;
		logger.info("Property bar set");
	}

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-tricky-target.xml");
		ctx.refresh();
		TrickyTarget t = ctx.getBean(TrickyTarget.class);
		ctx.close();
	}
}
