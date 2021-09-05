package com.spring_aop;

import com.spring_aop.dao.AccountDAO;
import com.spring_aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        accountDAO.addAccount(5,3);
        accountDAO.addAccount(3,4);
        System.out.println("---------- Calling Membership ------------");
        membershipDAO.addSillyMember();
        membershipDAO.addSillyMember();
        membershipDAO.addInvoke();

        context.close();
    }
}
