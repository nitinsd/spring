package com.apress.prospring5.ch4;

import java.io.File;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {
	private static final Logger logger = 
			LoggerFactory.getLogger(DestructiveBeanWithInterface.class);
	
    private File file;
    private String filePath;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + 
                    DestructiveBeanWithInterface.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        logger.info("File exists: " + file.exists());
    }

    @Override
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
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh(); 

        DestructiveBeanWithInterface bean = 
            (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");

        //destroy() is deprecated as of Spring Framework 5.0, in favor of close()
        ctx.close();
        logger.info("Called close() that destroy this context instance");
    }
}
