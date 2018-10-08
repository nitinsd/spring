package com.apress.prospring5.ch5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecureBean {
	private static Logger logger = LoggerFactory.getLogger(
			SecureBean.class);
			
    public void writeSecureMessage() {
        logger.info("Every time I learn something new, "
            + "it pushes some old stuff out of my brain");
    }
}
