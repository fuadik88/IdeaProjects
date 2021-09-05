package com.spring_aop;

import com.spring_aop.aspect.LoggingAspect;
import com.spring_aop.dao.AccountDAO;
import com.spring_aop.dao.MembershipDAO;
import com.spring_aop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAfterThrowing {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        System.out.println("---------- Calling Membership ------------");
        membershipDAO.addSillyMember();
        membershipDAO.addSillyMember();
        membershipDAO.addInvoke();
        System.out.println();

        System.out.println("ACCOUNTLIST AFTERRETURNING NULL: " + LoggingAspect.accountList);
        List<Account> accountList = null;
        try {
            accountList = accountDAO.findAccount("annen", 6); //Exception happens
        } catch (Exception e){
            System.out.println(e.getMessage()); //gives the same exception: index out of bounds...
        }
        System.out.println("Account list right after execution! : " + LoggingAspect.accountList);
        System.out.println("After returning Account List:");
        for (Account r : accountList)
            System.out.println(r);
        System.out.println("------------------------------");
        context.close();
    }
}