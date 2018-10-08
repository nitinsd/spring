package springaop.aspectj.logging;

import org.springframework.context.support.GenericXmlApplicationContext;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringAopAspectjExample {
	private static Logger logger = LoggerFactory.getLogger(
			SpringAopAspectjExample.class);
			
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        
        EmployeeManager manager = ctx.getBean(EmployeeManager.class);
        
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstName("Pete");
        emp1.setLastName("Johnson");
          
        manager.addEmployee(emp1);
        Employee emp =  manager.getEmployeeById(1); 
		
		logger.info("=============================");
		logger.info("SpringAopAspectjExample.main(...) added employee = " + emp.toString());
        
        //Add more CRUD methods calls here ...
        
        ctx.close();
    }
}
