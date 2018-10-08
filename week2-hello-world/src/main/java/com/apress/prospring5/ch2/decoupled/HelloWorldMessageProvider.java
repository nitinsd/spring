package com.apress.prospring5.ch2.decoupled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldMessageProvider implements MessageProvider {
	private static final Logger logger = 
		LoggerFactory.getLogger(HelloWorldMessageProvider.class);
	
    public HelloWorldMessageProvider(){
        logger.info(" --> HelloWorldMessageProvider: constructor called");
    }

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
