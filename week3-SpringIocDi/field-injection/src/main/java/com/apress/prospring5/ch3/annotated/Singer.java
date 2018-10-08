package com.apress.prospring5.ch3.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 2/15/17.
 */
@Service("singer")
public class Singer {
	private static final Logger logger = 
		LoggerFactory.getLogger(Singer.class);
		
	@Autowired
	private Inspiration inspirationBean;

	public void sing() {
		logger.info("... " + inspirationBean.getLyric());
	}
}
