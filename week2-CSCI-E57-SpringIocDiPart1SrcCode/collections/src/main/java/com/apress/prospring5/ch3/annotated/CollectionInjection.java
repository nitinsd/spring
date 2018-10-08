package com.apress.prospring5.ch3.annotated;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("injectCollection")
public class CollectionInjection {
	private static final Logger logger = 
		LoggerFactory.getLogger(CollectionInjection.class);

    /**
     *      @Resource(name="map") is equivalent with @Autowired @Qualifier("map")
     */
  //  @Autowired
 //   @Qualifier("map")
    @Resource(name="map")
    private Map<String, Object> map;

    @Resource(name="props")
    private Properties props;

    @Resource(name="set")
    private Set set;
    
    @Resource(name="list")
    private List list;

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();  

        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
        instance.displayInfo();

        ctx.close();
    }

    public void displayInfo() {
        logger.info("Map contents:\n");
        map.entrySet().stream().forEach(e -> logger.info("Key: " + e.getKey() + " - Value: " + e.getValue()));

        logger.info("\nProperties contents:\n");
        props.entrySet().stream().forEach(e -> logger.info("Key: " + e.getKey() + " - Value: " + e.getValue()));

        logger.info("\nSet contents:\n");
        set.forEach(obj -> logger.info("Value: " + obj));

        logger.info("\nList contents:\n");
        list.forEach(obj -> logger.info("Value: " + obj));
    }

}
