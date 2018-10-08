package com.apress.prospring5.ch3.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apress.prospring5.ch3.MessageProvider;
import com.apress.prospring5.ch3.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {
	private static final Logger logger = 
			LoggerFactory.getLogger(StandardOutMessageRenderer.class);
	
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
            "You must set the property messageProvider of class:"
            + StandardOutMessageRenderer.class.getName());
        }

        logger.info(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
