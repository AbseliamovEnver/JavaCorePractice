package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.model.Account;

public interface AccountRepository extends GenericRepository<Account, Long> {

    Account checkAccount(Long id, String password);

    boolean update(Account account);
}
