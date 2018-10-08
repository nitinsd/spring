package com.apress.prospring5.ch3.annotated;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 2/20/17.
 */
@Component("singer")
@Scope("prototype")
public class Singer {
	private static final Logger logger = LoggerFactory.getLogger(Singer.class);
    private String lyric = "I played a quick game of chess with the salt and pepper shaker";

    public void sing() {
		////Commented to prevent polluting of stdout
		//logger.info("Annotated Singer sing() lyric: " + lyric);
    }
}
