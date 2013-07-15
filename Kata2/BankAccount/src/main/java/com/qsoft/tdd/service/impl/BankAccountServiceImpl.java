package com.qsoft.tdd.service.impl;

import com.qsoft.tdd.dao.BankAccountTransactionDAO;
import com.qsoft.tdd.model.BankAccountTransaction;
import com.qsoft.tdd.service.BankAccountService;
import com.qsoft.tdd.dao.BankAccountDAO;
import com.qsoft.tdd.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: Hunter
 * Date: 7/8/13
 */

public class BankAccountServiceImpl implements BankAccountService
{
    BankAccountDAO bankAccountDAO;
    BankAccountTransactionDAO bankAccountTransactionDAO;

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
    public void deposit(BankAccount bankAccount, long money, String description)
    {
        bankAccount.setBalance(bankAccount.getBalance() + money);
        bankAccountTransactionDAO.updateDepositTime(new Date());
    }

    @Override
    public BankAccountTransaction findTransactionByAccount(BankAccount bankAccount)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
