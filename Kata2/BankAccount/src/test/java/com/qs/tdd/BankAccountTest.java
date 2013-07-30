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
        Mockito.when(bankAccountDAO.getAccount(Mockito.anyLong())).then(new Answer<BankAccount>()
        {
            public BankAccount answer(InvocationOnMock invocationOnMock) throws Throwable
            {
                return new BankAccount(123456789, 0);
            }
        });
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
}
