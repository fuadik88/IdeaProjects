package com.customer_tracker.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExps {
    @Pointcut("execution(String com.customer_tracker.controller.CustomerController.*(..))")
    void controllerPc(){}

    @Pointcut("execution(* com.customer_tracker.service.ServiceImpl.*(..))")
    void servicePc(){}

    @Pointcut("execution(* com.customer_tracker.dao.CustomerList.*(..))")
    void daoPc(){}

    @Pointcut("controllerPc() || servicePc() || daoPc()")
    void appFlow(){}
}
