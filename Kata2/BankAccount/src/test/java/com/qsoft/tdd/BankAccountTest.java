package com.qsoft.tdd;

import com.qsoft.tdd.dao.BankAccountDAO;
import com.qsoft.tdd.dao.BankAccountTransactionDAO;
import com.qsoft.tdd.model.BankAccount;
import com.qsoft.tdd.model.BankAccountTransaction;
import com.qsoft.tdd.service.BankAccountService;
import com.qsoft.tdd.service.impl.BankAccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

    @Mock
    BankAccountTransactionDAO bankAccountTransactionDAO;

    @InjectMocks
    BankAccountService bankAccountService = new BankAccountServiceImpl();

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

    @Test
    public void testFindAccountByAccountNumber()
    {
        BankAccount bankAccount = bankAccountService.findAccount("123456678");

        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testDeposit()
    {
        BankAccount bankAccount = bankAccountService.findAccount("123456678");
        long balanceBefore = bankAccount.getBalance();
        bankAccountService.deposit(bankAccount, 100, "just add 100 to this account.");
        assertEquals(100, bankAccount.getBalance() - balanceBefore);
    }

    @Test
    public void testTimeDeposit()
    {
        BankAccount bankAccount = bankAccountService.findAccount("123456678");
        bankAccountService.deposit(bankAccount, 100, "just add 100 to this account.");
        BankAccountTransaction bankAccountTransaction = bankAccountService.findTransactionByAccount(bankAccount);
        assertEquals(100, bankAccountTransaction.getDepositTime().getTime());
    }

}
