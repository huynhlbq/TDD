package com.qs.tdd.service;

import com.qs.tdd.model.BankAccount;

/**
 * User: Hunter
 * Date: 7/29/13
 */
public interface BankAccountService
{
    BankAccount openAccount(long accountNumber);
}
