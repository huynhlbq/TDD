package com.qs.tdd;

import com.qs.tdd.model.BankAccount;
import com.qs.tdd.service.BankAccountService;
import com.qs.tdd.service.impl.BankAccountServiceImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * User: Hunter
 * Date: 7/24/13
 */
public class BankAccountTest
{

    BankAccountService bankAccountService = new BankAccountServiceImpl();

    @Test
    public void testCreateAccount()
    {
        BankAccount bankAccount = bankAccountService.openAccount(123456678);
        assertEquals(0d, bankAccount.getBalance());
    }
}
