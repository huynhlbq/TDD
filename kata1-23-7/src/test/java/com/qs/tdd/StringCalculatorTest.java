package com.qs.tdd;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculatorTest
{
    @Test
    public void testAddEmptyString()
    {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testAddOneNumber()
    {
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void testAddTwoNumbers()
    {
        assertEquals(3, StringCalculator.add("1,2"));
    }
}
