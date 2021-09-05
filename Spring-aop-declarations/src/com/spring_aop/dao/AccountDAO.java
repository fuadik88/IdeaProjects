package com.spring_aop.dao;

import com.spring_aop.aspect.LoggingAspect;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(int i, int j){
        System.out.println(getClass() + " doing DB work: Adding an account...");
        System.out.println((int)Math.pow(i,j));
        System.out.println(LoggingAspect.msg);
    }
}
