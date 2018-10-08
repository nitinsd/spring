package com.apress.prospring5.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.prospring5.ch5.Guitarist;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
	private static Logger logger = LoggerFactory.getLogger(
			SimpleAfterReturningAdvice.class);
			
    public static void main(String... args) {
        Guitarist target = new Guitarist();

        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);

        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, 
             Object[] args, Object target) throws Throwable {
        logger.info("After '" + method.getName()+ "' put down guitar.");
    }
}
