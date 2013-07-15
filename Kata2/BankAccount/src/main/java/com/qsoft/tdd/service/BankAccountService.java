package com.qsoft.tdd.service;

import com.qsoft.tdd.model.BankAccount;

/**
 * User: Hunter
 * Date: 7/8/13
 */

public interface BankAccountService
{

    public BankAccount createAccount(String accountNumber);

    public BankAccount findAccount(String accountNumber);

}
