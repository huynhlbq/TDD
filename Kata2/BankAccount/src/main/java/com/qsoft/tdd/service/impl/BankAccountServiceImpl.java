package com.qsoft.tdd.service.impl;

import com.qsoft.tdd.service.BankAccountService;
import com.qsoft.tdd.dao.BankAccountDAO;
import com.qsoft.tdd.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: Hunter
 * Date: 7/8/13
 */

public class BankAccountServiceImpl implements BankAccountService
{
    BankAccountDAO bankAccountDAO;

    public BankAccount createAccount(String accountNumber)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccount(accountNumber);
        bankAccount.setBalance(0);
        return bankAccount;
    }

    public BankAccount findAccount(String accountNumber)
    {
        return bankAccountDAO.findAccount(accountNumber);
    }

    @Override
    public void deposit(String accountNumber, long money, String description)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
