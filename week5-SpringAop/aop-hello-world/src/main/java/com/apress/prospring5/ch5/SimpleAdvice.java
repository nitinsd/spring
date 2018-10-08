package com.apress.prospring5.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleAdvice implements MethodInterceptor {
	private static Logger logger = LoggerFactory.getLogger(
			SimpleAdvice.class);
			
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info(">> Invoking " + invocation.getMethod().getName());
        Object retVal = invocation.proceed();
        logger.info(">> Done\n");
        return retVal;
    }
}
