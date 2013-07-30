package com.qs.tdd.service;

import com.qs.tdd.model.BankAccount;
import com.qs.tdd.model.Transaction;

import java.util.Date;
import java.util.List;

/**
 * User: Hunter
 * Date: 7/29/13
 */
public interface BankAccountService
{
    BankAccount openAccount(long accountNumber);

    BankAccount getAccount(long accountNumber);

    void deposit(long accountNumber, double amount, String description, Date time);

    List<Transaction> getTransactions(BankAccount bankAccount, Date startTime, Date endTime);
}
