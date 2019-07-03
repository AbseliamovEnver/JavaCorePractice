package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.controller.AccountController;
import com.abselyamov.practice.module14.model.Account;
import com.abselyamov.practice.module14.model.AccountStatus;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    @Override
    public void add(Account account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AccountController.ACCOUNT_FILE, true))) {
            writer.write(account.getId() + "\t" + account.getLogin() + "\t" + account.getPassword() + "\t" + account.getStatus() + "\n");
        } catch (IOException e) {
            System.out.println("Exception write account file: " + e);
        }
    }

    public void update(long id, String login, String pass, AccountStatus status) {
        Set<Account> accounts = getAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AccountController.ACCOUNT_FILE))) {
            for (Account account : accounts) {
                if (account.getId() == id) {
                    writer.write(id + "\t" + login + "\t" + pass + "\t" + status + "\n");
                    continue;
                }
                writer.write(account.getId() + "\t" + account.getLogin() + "\t" + account.getPassword() + "\t" + account.getStatus() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getById(Long aLong) {
        return null;
    }

    @Override
    public Set<Account> getAll() {
        Set<Account> accounts = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountController.ACCOUNT_FILE))) {
            while (reader.ready()) {
                String[] data = reader.readLine().split("\t");
                accounts.add(new Account(Long.parseLong(data[0]), data[1], data[2], AccountStatus.valueOf(data[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void delete(Account account) {
        Set<Account> accounts = getAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AccountController.ACCOUNT_FILE))) {
            accounts.removeIf(acc -> acc.getId() == account.getId());
            for (Account acc : accounts) {
                writer.write(acc.getId() + "\t" + acc.getLogin() + "\t" + acc.getPassword() + "\t" + acc.getStatus() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}