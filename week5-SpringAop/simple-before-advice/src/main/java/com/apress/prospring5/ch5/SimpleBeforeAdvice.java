package com.apress.prospring5.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	private static Logger logger = LoggerFactory.getLogger(
			SimpleBeforeAdvice.class);
			
    public static void main(String... args) {
		
        Guitarist johnMayer = new Guitarist();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(johnMayer);

        Guitarist proxy = (Guitarist) pf.getProxy();

        proxy.sing();
    }

    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        logger.info("Before '" + method.getName() + "', tune guitar.");
    }
}
