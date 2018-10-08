package com.apress.prospring5.ch5;

import com.apress.prospring5.ch5.IsModified;
import com.apress.prospring5.ch5.IsModifiedAdvisor;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//IntroductionExample class shows how to assemble the advised proxy and then 
//tests the modification check code. 
public class IntroductionDemo {
	private static Logger logger = LoggerFactory.getLogger(
			IntroductionDemo.class);
			
    public static void main(String... args) {
        Contact target = new Contact();
        target.setName("John Mayer");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        //We set the optimize flag to true to force the use of the CGLIB(i.e. code genaration lib) 
        //With the CGLIB proxy, the original class is implemented by the proxy 
        //proxy along with the mixin interfaces.
        pf.setOptimize(true);

        Contact proxy = (Contact) pf.getProxy();
        IsModified proxyInterface = (IsModified)proxy;

        //We test first to see whether the proxy is an instance of TargetBean. 
        logger.info("Is Contact?: " + (proxy instanceof Contact));
        //Then to see whether it is an instance of IsModified.
        //Both tests return true when you are using the CGLIB 
        logger.info("Is IsModified?: " + (proxy instanceof IsModified));
        
        logger.info("Has been modified?: " + 
            proxyInterface.isModified());

        //Finally, we test the modification check code by first setting the name property 
        //to its current value and then to a new value, checking the value 
        //of the isModified flag each time. 
        proxy.setName("John Mayer");

        logger.info("Has been modified?: " + 
            proxyInterface.isModified());

        proxy.setName("Eric Clapton");

        logger.info("Has been modified?: " + 
            proxyInterface.isModified());
    }
}
