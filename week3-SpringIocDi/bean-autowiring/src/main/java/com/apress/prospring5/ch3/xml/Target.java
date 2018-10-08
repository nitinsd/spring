package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Target {
	private static final Logger logger = 
		LoggerFactory.getLogger(Target.class);
		
    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public Target() {
    }
    
    public Target(Foo foo) {
        logger.info("Target(Foo) called");
    }
    
    public Target(Foo foo, Bar bar) {
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
        ctx.load("classpath:spring/app-context-target.xml");
        ctx.refresh();

        Target t = null;
        
        logger.info("Using byName:\n");
        t = (Target) ctx.getBean("targetByName");
        
        logger.info("\nUsing byType:\n");
        t = (Target) ctx.getBean("targetByType");
        
        logger.info("\nUsing constructor:\n");
        t = (Target) ctx.getBean("targetConstructor");

        ctx.close();
        
    }
}
