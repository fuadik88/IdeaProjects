package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    public static String msg;

    @Before("execution(public * add*(..))")
    public void beforeAdvice(){
        System.out.println("Before advice of account addition triggered!");
        msg = "I've caught you";
    }
}

/*
* () matches a method with no arguments
* (*) matches a method with only one argument. String or Customer or int ...
* (..) matches a method with more than one parameter.
*
* execution(public * com.spring_aop.dao.*.*(..))  any method inside dao package with any arguments
* execution(public * com.spring_aop.dao.AccountDAO.add*(..)) methods starting with add with any arguments
* and also inside of AccountDAO class.
* */
