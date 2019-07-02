package com.abselyamov.practice.module14.model;

public class Account {

    private AccountStatus accountStatus;

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        if (accountStatus == null)
            this.accountStatus = AccountStatus.ACTIVE;
        else
            this.accountStatus = accountStatus;
    }
}
