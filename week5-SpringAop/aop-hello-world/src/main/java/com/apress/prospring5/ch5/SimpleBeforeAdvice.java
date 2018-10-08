package com.apress.prospring5.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	private static Logger logger = LoggerFactory.getLogger(
			SimpleBeforeAdvice.class);
			
    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        logger.info("Before method: " + method);
    }
}
