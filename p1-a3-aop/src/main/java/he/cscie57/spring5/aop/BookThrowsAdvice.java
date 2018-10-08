package he.cscie57.spring5.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import he.cscie57.spring5.aop.domain.model.Book;

public class BookThrowsAdvice implements ThrowsAdvice {
	private static Logger logger = LoggerFactory.getLogger(BookThrowsAdvice.class);
			
    public static void main(String... args) {
    	Book target = new Book("Design Patterns");

    	ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new BookThrowsAdvice());
        pf.setTarget(target);
        
       	Book proxy = (Book) pf.getProxy();

       	try {
            proxy.throwException();
        } catch (Throwable t) {
        }

    }

    public void afterThrowing(Method method, Object[] args, Object target, RuntimeException ex) throws Throwable {
        logger.info("***");
        logger.info("RuntimeException Capture");
        logger.info("Caught: " + ex.getClass().getName());
        logger.info("Method: " + method.getName());
        System.out.print("***\n");
    }

}
