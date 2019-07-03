package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Account;
import com.abselyamov.practice.module14.model.AccountStatus;
import com.abselyamov.practice.module14.repository.JavaIOAccountRepositoryImpl;
import com.abselyamov.practice.module14.utils.GetID;

import java.util.Set;

public class AccountController {
    public static final String ACCOUNT_FILE = "src/main/java/com/abselyamov/practice/module14/database/accounts.txt";
    GetID id = new GetID();
    JavaIOAccountRepositoryImpl javaIOAccountRepository = new JavaIOAccountRepositoryImpl();

    public void add(String login, String password, Long status) {
        AccountStatus accountStatus = null;
        for (int i = 0; i < AccountStatus.values().length; i++) {
            if (status == i)
                accountStatus = AccountStatus.values()[i];
        }
        Account account = new Account(id.getID(ACCOUNT_FILE), login, password, accountStatus);
        javaIOAccountRepository.add(account);
    }

    public void update(long id, String login, String password, long status) {
        Account account = getById(id);
        AccountStatus accountStatus = null;
        if (login.isEmpty())
            login = account.getLogin();
        if (password.isEmpty())
            password = account.getPassword();
        for (int i = 0; i < AccountStatus.values().length; i++) {
            if (status == i)
                accountStatus = AccountStatus.values()[i];
        }
        javaIOAccountRepository.update(id, login, password, accountStatus);
    }

    public Account getById(long id) {
        Set<Account> accounts = getAll();
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public Set<Account> getAll() {
        for (Account account : javaIOAccountRepository.getAll()) {
            System.out.println(account);
        }
        return javaIOAccountRepository.getAll();
    }

    public void delete(Account account){
        javaIOAccountRepository.delete(account);
    }

    public boolean checkAccount(Long id, String pass) {
        Account account = getById(id);
        if (account.getPassword().equals(pass))
            return true;
        return false;
    }

    public void getListStatus() {
        for (int i = 0; i < AccountStatus.values().length; i++) {
            System.out.println(i + "\t" + AccountStatus.values()[i]);
        }
    }
}
