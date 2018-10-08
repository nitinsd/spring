package he.cscie57.spring5.collections.driver;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import he.cscie57.spring5.collections.domain.model.Book;
import he.cscie57.spring5.collections.domain.model.Category;

public class Collections {
	private static final Logger logger = LoggerFactory.getLogger(Book.class);

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        Category cSet = ctx.getBean("categoryBeanSet", Category.class);
        Set<Book> booksSet = cSet.getBooksSet();
        Iterator<Book> itSet = booksSet.iterator();
        logger.info("***Start: Books in Set***");
        while(itSet.hasNext()){
        	Book b = itSet.next();
           logger.info(b.toString());
        }
        logger.info("***End: Books in Set***");

        Category cList = ctx.getBean("categoryBeanList", Category.class);
        List<Book> booksList = cList.getBooksList();
        Iterator<Book> itList = booksList.iterator();
        logger.info("***Start: Books in List***");
        while(itList.hasNext()){
        	Book b = itList.next();
           logger.info(b.toString());
        }
        logger.info("***End: Books in List***");

        Category cMap = ctx.getBean("categoryBeanMap", Category.class);
        Map<String,Book> booksMap = cMap.getBooksMap();
        Iterator<Map.Entry<String, Book>> entries = booksMap.entrySet().iterator();
        int i = 1;
        logger.info("***Start: Books in Map***");
        while (entries.hasNext()) {
            Map.Entry<String, Book> entry = entries.next();
            logger.info("Key" + i + ": " + entry.getKey() + ", Value = " + entry.getValue().toString());
            i++;
        }
        logger.info("***End: Books in Map***");

        ctx.close();
    }

}
