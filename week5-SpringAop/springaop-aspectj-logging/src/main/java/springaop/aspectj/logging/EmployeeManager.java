package springaop.aspectj.logging;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**All the methods defined inside EmployeeManager are joint points.
   EmployeeManager is advised object hence it is the target object.
   A proxy object is created when we ask the bean reference for 
   EmployeeManager class. 
   */
@Component
public class EmployeeManager {
    private static Logger logger = LoggerFactory.getLogger(
			EmployeeManager.class);
	private List<Employee> list = new ArrayList<>();
	
    public Employee getEmployeeById(Integer employeeId) {
        logger.info("Method getEmployeeById() called");
        return list.get(employeeId-1);
    }
 
    public void addEmployee(Employee employee) {
        logger.info("Method addEmployee() called");
		list.add(employee);
    }

    public List<Employee> getAllEmployee() {
    	logger.info("Method getAllEmployee() called");
        return list;
    }
    
    public void deleteEmployee(Integer employeeId) {
    	logger.info("Method deleteEmployee() called");
        //Provide implementation here ...
    }
 
    public void updateEmployee(Employee employee) {
    	logger.info("Method updateEmployee() called");
    	 //Provide implementation here ...
    }
}
