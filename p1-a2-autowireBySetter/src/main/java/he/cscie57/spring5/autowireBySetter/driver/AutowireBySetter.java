package he.cscie57.spring5.autowireBySetter.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import he.cscie57.spring5.autowireBySetter.domain.model.Book;
import he.cscie57.spring5.autowireBySetter.domain.model.Category;

public class AutowireBySetter {
	private static final Logger logger = LoggerFactory.getLogger(Book.class);

    public static void main( String[] args ) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        Category c = ctx.getBean("categoryBean", Category.class);
        Book book = c.getBook();
        
        logger.info(book.toString());
        
        ctx.close();
    }
}
