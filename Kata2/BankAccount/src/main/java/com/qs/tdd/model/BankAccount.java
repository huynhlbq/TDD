package com.qs.tdd.model;

/**
 * User: Hunter
 * Date: 7/29/13
 */
public class BankAccount
{
    private long accountNumber;
    private double balance;

    public BankAccount()
    {
    }

    public BankAccount(long accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setAccountNumber(long accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber()
    {
        return accountNumber;
    }
}
