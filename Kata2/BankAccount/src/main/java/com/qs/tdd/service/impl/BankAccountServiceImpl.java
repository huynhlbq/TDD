package com.qs.tdd.service.impl;

import com.qs.tdd.dao.BankAccountDAO;
import com.qs.tdd.dao.TransactionDAO;
import com.qs.tdd.model.BankAccount;
import com.qs.tdd.model.Transaction;
import com.qs.tdd.service.BankAccountService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: Hunter
 * Date: 7/29/13
 */
public class BankAccountServiceImpl implements BankAccountService
{
    private BankAccountDAO bankAccountDAO;
    private TransactionDAO transactionDAO;

    @Override
    public BankAccount openAccount(long accountNumber)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setBalance(0);
        return bankAccount;
    }

    @Override
    public BankAccount getAccount(long accountNumber)
    {
        return bankAccountDAO.getAccount(accountNumber);
    }

    @Override
    public void deposit(long accountNumber, double amount, String description, Date time)
    {
        BankAccount account = getAccount(accountNumber);
        account.setBalance(account.getBalance() + amount);
        bankAccountDAO.update(account);
        Transaction transaction = new Transaction();
        transaction.setBankAccount(account);
        transaction.setTransactionTimeStamp(time);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transactionDAO.create(transaction);
    }

    @Override
    public List<Transaction> getTransactions(BankAccount bankAccount, Date startTime, Date endTime)
    {
        return null;
    }
}
