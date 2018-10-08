package com.apress.prospring5.ch4;

import java.io.File;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DestructiveBean implements InitializingBean {
	private static Logger logger = LoggerFactory.getLogger(
			DestructiveBean.class);
			
    private File file;
    private String filePath;
    
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + DestructiveBean.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        logger.info("File exists: " + file.exists());
    }

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

        DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");

        //destroy() is deprecated as of Spring Framework 5.0, in favor of close()
        ctx.close();
        logger.info("Called close() that destroy this context instance");
    }
}
