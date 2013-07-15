package com.qsoft.tdd.service;

import com.qsoft.tdd.model.BankAccount;
import com.qsoft.tdd.model.BankAccountTransaction;

/**
 * User: Hunter
 * Date: 7/8/13
 */

public interface BankAccountService
{

    public BankAccount createAccount(String accountNumber);

    public BankAccount findAccount(String accountNumber);

    public void deposit(BankAccount bankAccount, long money, String description);

    public BankAccountTransaction findTransactionByAccount(BankAccount bankAccount);
}
