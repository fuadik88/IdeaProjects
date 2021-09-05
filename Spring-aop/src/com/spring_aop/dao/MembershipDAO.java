package com.spring_aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addSillyMember(){
        System.out.println(getClass() +  ". Membership added!");
        return true;
    }
}
