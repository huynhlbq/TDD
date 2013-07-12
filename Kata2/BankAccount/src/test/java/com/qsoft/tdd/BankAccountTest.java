package com.qsoft.tdd;

import com.qsoft.tdd.dao.BankAccountDAO;
import com.qsoft.tdd.model.BankAccount;
import com.qsoft.tdd.service.BankAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;


/**
 * User: Hunter
 * Date: 7/8/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/test-bundle-context.xml")
public class BankAccountTest
{
    @Mock
    BankAccountDAO bankAccountDAO;

    @Autowired
    BankAccountService bankAccountService;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        Mockito.when(bankAccountDAO.findAccount(Mockito.anyString())).then(new Answer<BankAccount>()
        {
            public BankAccount answer(InvocationOnMock invocationOnMock) throws Throwable
            {
                return new BankAccount("12345678", 0);
            }
        });
    }

    @Test
    public void testCreateAccount()
    {
        BankAccount bankAccount = bankAccountService.createAccount("123456678");

        assertEquals(0, bankAccount.getBalance());
    }

}
