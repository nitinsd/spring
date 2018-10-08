package com.apress.prospring5.ch3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 2/20/17.
 */
public class Singer {
	private static final Logger logger =  LoggerFactory.getLogger(Singer.class);
	
    private String lyric = "I played a quick game of chess with the salt and pepper shaker";

    public void sing() {
		//Commented to prevent polluting of stdout
       // logger.info("Not annotated Singer sing() lyric: " + lyric);
    }
}
