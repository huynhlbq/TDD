package com.qsoft.tdd.model;

/**
 * User: Hunter
 * Date: 7/8/13
 */
public class BankAccount
{
    private long balance;
    private String account;

    public BankAccount()
    {
    }

    public BankAccount(String account, long balance)
    {
        this.account = account;
        this.balance = balance;
    }


    public long getBalance()
    {
        return balance;
    }

    public void setBalance(long balance)
    {
        this.balance = balance;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }
}
