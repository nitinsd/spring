package com.apress.prospring5.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponentsXml {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer",
            MessageRenderer.class);

        messageRenderer.render();
        ctx.close();
    }
}
