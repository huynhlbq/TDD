package com.qsoft.tdd.model;

import java.util.Date;

/**
 * User: Hunter
 * Date: 7/15/13
 */
public class BankAccountTransaction
{
    private BankAccount bankAccount;

    private Date depositTime;

    public BankAccount getBankAccount()
    {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

    public Date getDepositTime()
    {
        return depositTime;
    }

    public void setDepositTime(Date depositTime)
    {
        this.depositTime = depositTime;
    }
}
