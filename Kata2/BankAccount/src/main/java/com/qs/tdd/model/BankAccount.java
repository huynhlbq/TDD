package com.qs.tdd.model;

import java.util.Date;

/**
 * User: Hunter
 * Date: 7/29/13
 */
public class BankAccount
{
    private long accountNumber;
    private double balance;
    private Date timeCreated;

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

    public void setTimeCreated(Date timeCreated)
    {
        this.timeCreated = timeCreated;
    }

    public Date getTimeCreated()
    {
        return timeCreated;
    }
}
