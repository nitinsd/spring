package com.apress.prospring5.ch5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 3/26/17.
 */
public class Guitarist implements Singer {
	private static Logger logger = LoggerFactory.getLogger(
			Guitarist.class);
			
	private String lyric="You're gonna live forever in me";

	@Override
	public void sing(){
		logger.info("Guitarist.sing() = " + lyric);
	}

}
