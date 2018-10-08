package com.apress.prospring5.ch4;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class JavaConfigExampleOne {
    public static void main(String... args) {
    	//Note that there is no loading of a config file here. Config is done loading AppConfigOne.class
        ApplicationContext ctx = new 
            AnnotationConfigApplicationContext(AppConfigOne.class);

        MessageRenderer renderer =
            ctx.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();
    }
}
