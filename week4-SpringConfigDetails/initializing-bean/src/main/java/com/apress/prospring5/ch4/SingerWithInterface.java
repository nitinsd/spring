package com.apress.prospring5.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingerWithInterface implements InitializingBean {
	private static final Logger logger = 
		LoggerFactory.getLogger(SingerWithInterface.class);
		
    private static final String DEFAULT_NAME = "Eric Clapton";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

	/* Impelementation of InitializingBean interface. Invoked by a BeanFactory after it 
	   has set all bean properties supplied. 
	*/
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing bean");

        if (name == null) {
        	logger.info("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " 
                    + SingerWithInterface.class);
        }
    }

    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();
    }

    private static SingerWithInterface getBean(String beanName,
            ApplicationContext ctx) {
        try {
            SingerWithInterface bean = (SingerWithInterface) ctx.getBean(beanName);
            logger.info(bean.toString());
            return bean;
        } catch (BeanCreationException ex) {
            logger.info("An error occurred in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }
}
