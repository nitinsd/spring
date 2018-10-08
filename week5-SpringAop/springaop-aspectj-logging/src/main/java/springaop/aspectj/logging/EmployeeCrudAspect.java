package springaop.aspectj.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** With the @Aspect annotation we are creating a logging aspect. 
     This aspect class should be registered in app-context-xml.xml file.
     Methods logBefore() and logAfter() are advices.
     The expressions passed in @Before and @After annotations 
     (i.e. “execution(* EmployeeManager.getEmployeeById(..))“) are pointcuts.
*/
@Aspect
public class EmployeeCrudAspect {
    private static Logger logger = LoggerFactory.getLogger(
			 EmployeeCrudAspect.class);
			
    @Before("execution(* EmployeeManager.getEmployeeById(..))")
    public void logBeforeV1(JoinPoint joinPoint)
    {
        logger.info("EmployeeCrudAspect.logBeforeV1() : " + 
        		joinPoint.getSignature().getName());
    }
     
    @Before("execution(* EmployeeManager.*(..))")
    public void logBeforeV2(JoinPoint joinPoint)
    {
        logger.info("EmployeeCrudAspect.logBeforeV2() : " + 
        		joinPoint.getSignature().getName());
    }
     
    @After("execution(* EmployeeManager.getEmployeeById(..))")
    public void logAfterV1(JoinPoint joinPoint)
    {
        logger.info("EmployeeCrudAspect.logAfterV1() : " + 
        		joinPoint.getSignature().getName());
    }
     
    @After("execution(* EmployeeManager.*(..))")
    public void logAfterV2(JoinPoint joinPoint)
    {
        logger.info("EmployeeCrudAspect.logAfterV2() : " + 
        		joinPoint.getSignature().getName());
    }
    
    //Add other CRUD related methods here ...
}
