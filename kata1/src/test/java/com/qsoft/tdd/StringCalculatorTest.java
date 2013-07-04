package com.qsoft.tdd;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: Hunter
 * Date: 7/3/13
 */
public class StringCalculatorTest
{
    @Test
    public void stringAddEmptyTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public void stringAddOneParamTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(4, calculator.add("4"));
    }

    @Test
    public void stringAddTwoParamTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(10, calculator.add("4,6"));
    }

    @Test
    public void stringAddWithNewLineTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(15, calculator.add("4\n5,6"));
    }

    @Test
    public void stringAddWithMoreDelimiterTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(15, calculator.add("//;4\n5;6"));
    }

    @Test(expected = Exception.class)
    public void stringAddNegativeNumberTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(15, calculator.add("//;4\n-5;6"));
    }
}
