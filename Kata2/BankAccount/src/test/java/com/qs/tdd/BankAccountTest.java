package com.qs.tdd;

import com.qs.tdd.dao.BankAccountDAO;
import com.qs.tdd.model.BankAccount;
import com.qs.tdd.service.BankAccountService;
import com.qs.tdd.service.impl.BankAccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * User: Hunter
 * Date: 7/24/13
 */
public class BankAccountTest
{
    @Mock
    private BankAccountDAO bankAccountDAO;

    @InjectMocks
    BankAccountService bankAccountService = new BankAccountServiceImpl();

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        final BankAccount cacheAccountForModify = new BankAccount(123456789, 0);

        Mockito.when(bankAccountDAO.getAccount(Mockito.anyLong())).then(new Answer<BankAccount>()
        {
            public BankAccount answer(InvocationOnMock invocationOnMock) throws Throwable
            {
                return cacheAccountForModify;
            }
        });

        doAnswer(new Answer<Void>()
        {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable
            {
                cacheAccountForModify.setBalance(((BankAccount) invocation.getArguments()[0]).getBalance());
                return null;
            }
        }).when(bankAccountDAO).update((BankAccount) anyObject());

    }

    @Test
    public void testCreateAccount()
    {
        BankAccount bankAccount = bankAccountService.openAccount(123456789);
        assertEquals(0d, bankAccount.getBalance());
    }

    @Test
    public void testGetAccount()
    {
        bankAccountService.openAccount(123456789);
        BankAccount bankAccount = bankAccountService.getAccount(123456789);
        assertNotNull(bankAccount);
        assertEquals(123456789, bankAccount.getAccountNumber());
    }

    @Test
    public void testDeposit()
    {
        bankAccountService.openAccount(123456789);
        bankAccountService.deposit(123456789, 9999d, "deposit 9999$");
        BankAccount bankAccount = bankAccountService.getAccount(123456789);
        assertNotNull(bankAccount);
        assertEquals(123456789, bankAccount.getAccountNumber());
        assertEquals(9999d, bankAccount.getBalance());
    }
}
