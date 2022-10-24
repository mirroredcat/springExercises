package be.abis.springexercises.aspect;

import be.abis.springexercises.exceptions.EnrollException;
import be.abis.springexercises.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    static Logger logException = LogManager.getLogger("exceptionLogger");
    static Logger logInfo = LogManager.getLogger("info");

    @Before("MyPointcuts.enrollingSomeone()")
    public void sayPersonIsEnrolled(JoinPoint jp){
        String firstName = ((Person)jp.getArgs()[0]).getFirstName();

        logInfo.info("Person was enrolled");
        System.out.println("Enrolling "+ firstName + " ...");
    }

    @AfterThrowing(pointcut="MyPointcuts.enrollingSomeone()", throwing = "exc")
    public void afterEnrollmentException(EnrollException exc){
        logException.error("Something happened: "+ exc.getMessage());
        System.out.println("Something happened: " + exc.getMessage());
    }
}
