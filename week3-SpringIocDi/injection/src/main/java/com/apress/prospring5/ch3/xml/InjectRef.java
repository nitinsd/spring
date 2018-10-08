package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import com.apress.prospring5.ch3.Oracle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InjectRef {
	private static final Logger logger = 
		LoggerFactory.getLogger(InjectRef.class);
		
    private Oracle oracle;

    public void setOracle(Oracle oracle) { 
        this.oracle = oracle;
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
        logger.info("injectRef = " + injectRef.toString());

        ctx.close();
    }

    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
