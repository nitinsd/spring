package he.cscie57.spring5.aop.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book {
	String title; 

	private static Logger logger = LoggerFactory.getLogger(Book.class);

	public Book(String title) {
		this.title = title;
	}
	
	public void reading() {
		logger.info("Reading " + title + " book");
	}
	
	public void throwException() {
		throw new RuntimeException("Book Bean Exception");
	}
}
