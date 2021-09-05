package com.spring_aop.dao;

import com.spring_aop.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account){
        System.out.println("Account: " + account.getName() + " successfully added");
    }

    public List<Account> findAccount(String hoyt, int btch){
        Account acc1 = new Account("John", "Silver");
        Account acc2 = new Account("Gwen", "Gold");
        Account acc3 = new Account("Peter", "GrandMaster");
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
        accountList.remove(7);

        return accountList;
    }
}
