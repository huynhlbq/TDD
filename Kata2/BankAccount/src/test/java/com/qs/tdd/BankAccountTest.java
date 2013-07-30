package com.qs.tdd;

import com.qs.tdd.dao.BankAccountDAO;
import com.qs.tdd.dao.TransactionDAO;
import com.qs.tdd.model.BankAccount;
import com.qs.tdd.model.Transaction;
import com.qs.tdd.service.BankAccountService;
import com.qs.tdd.service.impl.BankAccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.doAnswer;

/**
 * User: Hunter
 * Date: 7/24/13
 */
public class BankAccountTest
{
    public static final long TEST_ACCOUNT_NUMBER = 123456789;
    @Mock
    private BankAccountDAO bankAccountDAO;

    @Mock
    private TransactionDAO transactionDAO;

    @InjectMocks
    BankAccountService bankAccountService = new BankAccountServiceImpl();

    private Date depositTime;
    private Date withdrawTime;

    @Before
    public void setup() throws ParseException
    {
        MockitoAnnotations.initMocks(this);

        depositTime = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse("2013/07/30 11:10:10");
        withdrawTime = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse("2013/07/30 14:13:12");

        final BankAccount cacheAccountForModify = new BankAccount(TEST_ACCOUNT_NUMBER, 0);

        final List<Transaction> allTransactions = new ArrayList<Transaction>();

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

        doAnswer(new Answer<Void>()
        {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable
            {
                allTransactions.add((Transaction) invocation.getArguments()[0]);
                return null;
            }
        }).when(transactionDAO).create((Transaction) anyObject());

        Mockito.when(transactionDAO.findByAccount((BankAccount) Mockito.anyObject())).then(new Answer<List<Transaction>>()
        {
            public List<Transaction> answer(InvocationOnMock invocationOnMock) throws Throwable
            {
                return allTransactions;
            }
        });
    }

    @Test
    public void testCreateAccount()
    {
        BankAccount bankAccount = bankAccountService.openAccount(TEST_ACCOUNT_NUMBER);
        assertEquals(0d, bankAccount.getBalance());
    }

    @Test
    public void testGetAccount()
    {
        bankAccountService.openAccount(TEST_ACCOUNT_NUMBER);
        BankAccount bankAccount = bankAccountService.getAccount(TEST_ACCOUNT_NUMBER);
        assertNotNull(bankAccount);
        assertEquals(TEST_ACCOUNT_NUMBER, bankAccount.getAccountNumber());
    }

    @Test
    public void testDeposit()
    {
        bankAccountService.openAccount(TEST_ACCOUNT_NUMBER);
        bankAccountService.deposit(TEST_ACCOUNT_NUMBER, 9999d, "deposit 9999$", depositTime);
        BankAccount bankAccount = bankAccountService.getAccount(TEST_ACCOUNT_NUMBER);
        assertNotNull(bankAccount);
        assertEquals(TEST_ACCOUNT_NUMBER, bankAccount.getAccountNumber());
        assertEquals(9999d, bankAccount.getBalance());
    }

    @Test
    public void testDepositTransaction()
    {
        bankAccountService.openAccount(TEST_ACCOUNT_NUMBER);
        bankAccountService.deposit(TEST_ACCOUNT_NUMBER, 9999d, "deposit 9999$", depositTime);
        BankAccount bankAccount = bankAccountService.getAccount(TEST_ACCOUNT_NUMBER);

        //before transaction 1 milli
        Date startTime = new Date(depositTime.getTime() - 1);
        //after transaction 1 milli
        Date endTime = new Date(depositTime.getTime() + 1);
        List<Transaction> transactions = bankAccountService.getTransactions(bankAccount, startTime, endTime);
        assertNotNull(transactions);
        assertEquals(1, transactions.size());
        assertEquals(depositTime, transactions.get(0).getTransactionTimeStamp());
    }

    @Test
    public void testWithdraw()
    {
        bankAccountService.openAccount(TEST_ACCOUNT_NUMBER);
        bankAccountService.deposit(TEST_ACCOUNT_NUMBER, 9999d, "deposit 9999$", new Date());
        bankAccountService.withdraw(TEST_ACCOUNT_NUMBER, 99d, "withdraw 99$", new Date());
        BankAccount bankAccount = bankAccountService.getAccount(TEST_ACCOUNT_NUMBER);
        assertNotNull(bankAccount);
        assertEquals(TEST_ACCOUNT_NUMBER, bankAccount.getAccountNumber());
        assertEquals(9900d, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawTransaction()
    {
        bankAccountService.openAccount(TEST_ACCOUNT_NUMBER);
        bankAccountService.withdraw(TEST_ACCOUNT_NUMBER, 11d, "withdraw 11$", withdrawTime);
        BankAccount bankAccount = bankAccountService.getAccount(TEST_ACCOUNT_NUMBER);

        //before transaction 1 milli
        Date startTime = new Date(withdrawTime.getTime() - 1);
        //after transaction 1 milli
        Date endTime = new Date(withdrawTime.getTime() + 1);
        List<Transaction> transactions = bankAccountService.getTransactions(bankAccount, startTime, endTime);
        assertNotNull(transactions);
        assertEquals(1, transactions.size());
        assertEquals(withdrawTime, transactions.get(0).getTransactionTimeStamp());
    }

    @Test
    public void testAllTransaction()
    {
        bankAccountService.openAccount(TEST_ACCOUNT_NUMBER);
        bankAccountService.deposit(TEST_ACCOUNT_NUMBER, 9999d, "deposit 9999$", depositTime);
        bankAccountService.withdraw(TEST_ACCOUNT_NUMBER, 11d, "withdraw 11$", withdrawTime);
        BankAccount bankAccount = bankAccountService.getAccount(TEST_ACCOUNT_NUMBER);

        List<Transaction> transactions = bankAccountService.getAllTransactions(bankAccount);
        assertNotNull(transactions);
        assertEquals(2, transactions.size());
    }
}
