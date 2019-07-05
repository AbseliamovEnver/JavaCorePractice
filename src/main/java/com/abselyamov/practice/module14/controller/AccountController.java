package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Account;
import com.abselyamov.practice.module14.model.AccountStatus;
import com.abselyamov.practice.module14.repository.AccountRepository;
import com.abselyamov.practice.module14.repository.JavaIOAccountRepositoryImpl;

import java.util.Set;

public class AccountController {
    AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();

    public void add(String login, String password, Long status) {
        AccountStatus accountStatus = null;
        for (int i = 0; i < AccountStatus.values().length; i++) {
            if (status == i)
                accountStatus = AccountStatus.values()[i];
        }
        Account account = new Account(0, login, password, accountStatus);
        accountRepository.add(account);
    }

    public String getById(long id) {
        Account account = accountRepository.getById(id);
        if (account != null)
            return "Account with id \'" + id + "\' have login \'"
                    + account.getLogin() + "\' and status \'" + account.getStatus() + "\'";
        return "Account with id \'" + id + "\' not found.";
    }

    public String getByName(String login) {
        Account account = accountRepository.getByName(login);
        if (account != null)
            return "Account with login \'" + account.getLogin() + "\' have id \'"
                    + account.getId() + "\' and status \'" + account.getStatus() + "\'";
        return "Account with name \'" + login + "\' not found.";
    }

    public Set<Account> getListAccounts() {
        Set<Account> accounts = accountRepository.getAll();
        if (accounts != null) {
            for (Account account : accounts)
                System.out.println(account.getId() + "\t" + account.getLogin() + "\t" + account.getStatus());
            return accounts;
        } else System.out.println("List accounts is empty.");
        return null;
    }

    public void update(long id, String login, String password, long status) {
        AccountStatus accountStatus = null;
        for (int i = 0; i < AccountStatus.values().length; i++) {
            if (status == i)
                accountStatus = AccountStatus.values()[i];
        }
        boolean update = accountRepository.update(new Account(id, login, password, accountStatus));
        if (update)
            System.out.println("Update account is successful");
        else System.out.println("Account update failed.");

    }

    public void delete(Long id) {
        Account account = accountRepository.delete(id);
        if (account != null)
            System.out.println("Account with id \'" + account.getId() + "\' and login \'"
                    + account.getLogin() + "\' deleted successfully.");
        else
            System.out.println("Skill with id \'" + id + "\' not found.");
    }

    public boolean checkAccount(Long id, String pass) {
        Account account = accountRepository.checkAccount(id, pass);
        if (account != null)
            return true;
        return false;
    }

    public void getListStatus() {
        for (int i = 0; i < AccountStatus.values().length; i++) {
            System.out.println(i + "\t" + AccountStatus.values()[i]);
        }
    }
}
