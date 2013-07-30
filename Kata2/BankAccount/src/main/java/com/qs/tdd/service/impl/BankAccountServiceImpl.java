package com.qs.tdd.service.impl;

import com.qs.tdd.model.BankAccount;
import com.qs.tdd.service.BankAccountService;

/**
 * User: Hunter
 * Date: 7/29/13
 */
public class BankAccountServiceImpl implements BankAccountService
{
    @Override
    public BankAccount openAccount(long accountNumber)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setBalance(0);
        return bankAccount;
    }
}
