package com.qsoft.tdd.dao;

import com.qsoft.tdd.model.BankAccount;

/**
 * User: Hunter
 * Date: 7/8/13
 */
public interface BankAccountDAO
{
    BankAccount findAccount(String accountNumber);
}
