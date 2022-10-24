package be.abis.springexercises.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
/*
    @Pointcut("execution(public * be.abis.springexercises.*.*Person(..))")
    public void doSomethingPointcut(){

    }
     */

    @Pointcut("execution(public * be.abis.springexercises.service.*.*Session(..))")
    public void enrollingSomeone(){}

    @Pointcut("execution(public * be.abis.springexercises.service.*.find*(..))")
    public void timerForFind(){}

}


