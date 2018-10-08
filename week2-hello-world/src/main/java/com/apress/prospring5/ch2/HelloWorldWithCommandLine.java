package com.apress.prospring5.ch2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldWithCommandLine {
	private static final Logger logger = 
		LoggerFactory.getLogger(HelloWorldWithCommandLine.class);
	
    public static void main(String... args) {
        if (args.length > 0) {
            logger.info("Hello " + args[0]);
        } else {
            logger.info("Hello World!");
        }
    }
}
