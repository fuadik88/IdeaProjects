package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PredefinedExpressions {
    @Pointcut("execution(public * com.spring_aop.dao.*.add*(..))")
    void pcExpression(){}

    @Pointcut("execution(* com.spring_aop.dao.*.get*())")
    void getters(){}

    @Pointcut("execution(* com.spring_aop.dao.*.set*())")
    void setters(){}

    @Pointcut("execution(* com.spring_aop.dao.AccountDAO.find*(..))")
    void afterPC(){}

    @Pointcut("execution(* com.spring_aop.service.TrafficFortuneService.get*())")
    void getFortune(){}
}
