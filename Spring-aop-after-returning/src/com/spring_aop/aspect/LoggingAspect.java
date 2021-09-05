package com.spring_aop.aspect;

import com.spring_aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
    public static String msg;
    public static List<Account> accountList;

    @Before("PredefinedExpressions.pcExpression()")
    void beforeAdvice() {
        System.out.println("Before advice of account addition triggered!");
        msg = "I've caught you";
    }

    @Before("PredefinedExpressions.pcExpression() && !(PredefinedExpressions.getters() || PredefinedExpressions.setters())")
    void restAnalysis(JoinPoint joinPoint) {
        System.out.println("@Before: API is being initialized");
        //display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); //getSignature() returns
        System.out.println("Method signature: " + methodSignature);                  // raw signature
    }

    @AfterReturning(value = "com.spring_aop.aspect.PredefinedExpressions.afterPC()", returning = "accList")
    void fetchList(JoinPoint joinPoint, List<Account> accList) {
        Iterator<Account> iterator = accList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next().setLevel("Hacked " + i++ + " times \uD83D\uDE0E");
        }

        accountList = accList;

        System.out.println(joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();
        for(Object r : args)
            System.out.println(r);
    }

    @AfterThrowing(value = "com.spring_aop.aspect.PredefinedExpressions.afterPC()", throwing = "exc")
    void fetchListThrow(JoinPoint joinPoint, Exception exc) throws NoSuchMethodException {
        long hoyt = System.currentTimeMillis();
        System.out.println("Exception throwed, Go f*ck yourself" + joinPoint.getSignature().toShortString());
        Object[] args = joinPoint.getArgs();
        System.out.println(exc.getMessage());
        System.out.println(getClass().getDeclaredMethod("fetchListThrow", JoinPoint.class, Exception.class));
        long foyt = System.currentTimeMillis();
        System.out.println("Processing time: " + (foyt - hoyt));
    }

    @Around("com.spring_aop.aspect.PredefinedExpressions.getFortune()")
    Object aroundFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long finish = System.currentTimeMillis();

        System.out.println("Around advice processing time: " + (finish - start));

        return result;
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
 *
 * @After advice always run regardless of success or failure. If success, will run after AfterReturning
 * if failure, will run after AfterThrowing. @After always run at the end.
 * F.I
 * */
