package com.qs.tdd.dao;

import com.qs.tdd.model.BankAccount;

/**
 * User: Hunter
 * Date: 7/29/13
 */
public interface BankAccountDAO
{
    public void save(BankAccount bankAccount);

    BankAccount getAccount(long accountNumber);

    void update(BankAccount account);
}
