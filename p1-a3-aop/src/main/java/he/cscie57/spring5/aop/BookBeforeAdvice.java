package he.cscie57.spring5.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import he.cscie57.spring5.aop.domain.model.Book;

public class BookBeforeAdvice implements MethodBeforeAdvice {
	private static Logger logger = LoggerFactory.getLogger(BookBeforeAdvice.class);
			
    public static void main(String... args) {
    	Book target = new Book("Design Patterns");

    	ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new BookBeforeAdvice());
        pf.setTarget(target);
        
        Book proxy = (Book) pf.getProxy();

        proxy.reading();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info("Before '" + method.getName()+ "' buy the book.");
    }

}
