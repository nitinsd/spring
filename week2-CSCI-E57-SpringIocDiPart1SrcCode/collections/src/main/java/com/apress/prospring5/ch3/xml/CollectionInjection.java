package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionInjection {
	private static final Logger logger = 
		LoggerFactory.getLogger(CollectionInjection.class);
		
	private Map<String, Object> map;
	private Properties props;
	private Set set;
	private List list;

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();

		CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();

		ctx.close();
	}

	public void displayInfo() {
		logger.info("Map contents:\n");
		/* map.entrySet() returns  a Set view of the mappings contained in this map (i.e Set<Map.Entry<K,V>>)
		 * map.entrySet().stream() returns a sequential Stream with this collection as its source.
		 * map.entrySet().stream().forEach(...) performs an action for each element of this stream.
		 */
		map.entrySet().stream().forEach(e -> logger.info("Key: " + e.getKey() + " - Value: " + e.getValue()));

		logger.info("\nProperties contents:\n");
		props.entrySet().stream().forEach(e -> logger.info("Key: " + e.getKey() + " - Value: " + e.getValue()));

		logger.info("\nSet contents:\n");
		set.forEach(obj -> logger.info("Value: " + obj));

		logger.info("\nList contents:\n");
		list.forEach(obj -> logger.info("Value: " + obj));
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
}
