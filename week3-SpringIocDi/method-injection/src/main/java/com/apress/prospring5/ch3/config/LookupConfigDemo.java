package com.apress.prospring5.ch3.config;

import com.apress.prospring5.ch3.annotated.DemoBean;
import com.apress.prospring5.ch3.annotated.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 2/19/17.
 */
public class LookupConfigDemo {
    private static final Logger logger = 
		LoggerFactory.getLogger(LookupConfigDemo.class);
	
	@Configuration
	@ComponentScan(basePackages = {"com.apress.prospring5.ch3.annotated"})
	public static class LookupConfig {}

	public static void main(String... args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);
		//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(s-> logger.info(s));

		DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
		DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);


		displayInfo("abstractLookupBean", abstractBean);
		displayInfo("standardLookupBean", standardBean);

		ctx.close();
	}

	public static void displayInfo(String beanName, DemoBean bean) {
		Singer singer1 = bean.getMySinger();
		Singer singer2 = bean.getMySinger();

		logger.info("[" + beanName + "]: Singer Instances the Same?  "
				+ (singer1 == singer2));

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");

		for (int x = 0; x < 100000; x++) {
			Singer singer = bean.getMySinger();
			singer.sing();
		}

		stopWatch.stop();
		logger.info("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
	}
}
