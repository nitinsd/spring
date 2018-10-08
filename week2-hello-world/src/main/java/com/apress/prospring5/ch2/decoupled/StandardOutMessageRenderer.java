package com.apress.prospring5.ch2.decoupled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardOutMessageRenderer implements MessageRenderer {
	private static final Logger logger = 
		LoggerFactory.getLogger(StandardOutMessageRenderer.class);
	
	private MessageProvider messageProvider;

	public StandardOutMessageRenderer(){
		logger.info(" --> StandardOutMessageRenderer: constructor called");
	}

	//@Override
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
		logger.info(" --> StandardOutMessageRenderer: setting the provider");
		this.messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}
