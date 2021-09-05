package com.spring_aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addSillyMember(){
        System.out.println("Membership added!");
        return true;
    }

    public void addInvoke(){
        System.out.println("addInvoke method ran");
    }
}
