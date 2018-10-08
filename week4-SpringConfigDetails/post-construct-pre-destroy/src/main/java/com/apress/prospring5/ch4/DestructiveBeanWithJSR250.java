package com.apress.prospring5.ch4;

import java.io.File;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestructiveBeanWithJSR250 {
	private static final Logger logger = LoggerFactory.getLogger(DestructiveBeanWithJSR250.class);
	
    private File file;
    private String filePath;
    
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + 
                    DestructiveBeanWithJSR250.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        logger.info("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        logger.info("Destroying Bean");

        if(!file.delete()) {
            logger.error("ERROR: failed to delete file.");
        }

        logger.info("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String... args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh(); 

        DestructiveBeanWithJSR250 bean = 
            (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");
      
        ctx.close();
        
    }
}
