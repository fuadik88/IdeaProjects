package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
    public static String msg;

    @Before("PredefinedExpressions.pcExpression()")
    void beforeAdvice(){
        System.out.println("Before advice of account addition triggered!");
        msg = "I've caught you";
    }

    @Before("PredefinedExpressions.pcExpression() && !(PredefinedExpressions.getters() || PredefinedExpressions.setters())")
    void restAnalysis(){
        System.out.println("API is being initialized");
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
