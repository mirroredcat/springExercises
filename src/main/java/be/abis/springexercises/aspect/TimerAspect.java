package be.abis.springexercises.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    @Around("MyPointcuts.timerForFind()")
    public Object timing(ProceedingJoinPoint pjp){
        Object o = null;
        try{
            long start = System.nanoTime();
            o = pjp.proceed();
            long end = System.nanoTime();
            System.out.println("time taken by "+ pjp.getSignature().getName() +
                    " : " + ((end-start)/1_000_000.0 + " milliseconds"));
        } catch (Throwable e){
            e.printStackTrace();
        }
        return o;
    }

}
