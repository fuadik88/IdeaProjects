package com.customer_tracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger log = Logger.getLogger(getClass().getName());

    @Before("com.customer_tracker.aspect.PointcutExps.appFlow()")
    void beforeLogging(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        log.info("@Before executed, method called => " + method);

        for (Object r : args)
            System.out.println("Argument: " + r);
    }

    @AfterReturning(value = "com.customer_tracker.aspect.PointcutExps.appFlow()", returning = "result")
    void afterLogging(JoinPoint joinPoint, Object result){
        String method = joinPoint.getSignature().toShortString();
        log.info("From method => " + method);

        log.info("Returned data => " + result);
    }
}
