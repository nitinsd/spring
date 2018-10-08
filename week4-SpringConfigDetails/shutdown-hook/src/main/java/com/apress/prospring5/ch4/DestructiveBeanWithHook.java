package com.apress.prospring5.ch4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestructiveBeanWithHook {
	private static final Logger logger = LoggerFactory.getLogger(DestructiveBeanWithHook.class);
	
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " +
                    DestructiveBeanWithHook.class);
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
        ctx.registerShutdownHook();
        ctx.refresh();

        ctx.getBean(DestructiveBeanWithHook.class);

    }
}
