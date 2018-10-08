package com.apress.prospring5.ch3.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.prospring5.ch3.MessageProvider;
import com.apress.prospring5.ch3.MessageRenderer;

// full file is scanned for all annotations

@Service("messageRenderer") 
// @Service means this is a specific type of Bean that handles services for this application. 
// In more comlicated applications, there is a Service layer
// This is saying this is an injectable bean with the name "messageRenderer"
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
    @Autowired
    // autowire this will tell spring this setter property should come from a Bean.
    // name of the bean is derived from the setter method name "messageProvider"
    // once it has the been, then spring will scan the rest of the packahe in the xml file to
    // find a bean named messageProvider. And it will find HelloWorldMessageProvider because it
    // is annotated as a @Service("messageProvider")
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
