package com.qsoft.tdd;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: Hunter
 * Date: 7/4/13
 */

@SuppressWarnings("deprecation")
public class StringCalculatorTest
{
    @Test
    public void addEmptyStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public void addMultiParamsTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(20, calculator.add("1,2,7,10"));
    }

    @Test
    public void addWithNewLineTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void addMoreDelimiterTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test(expected = Exception.class)
    public void addNegativeTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        calculator.add("2;-3,4");
    }

    @Test
    public void addGT1000Test() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    public void addWithAnyDelimiterLengthTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void addWithDefinedDelimiterTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(6, calculator.add("//[*][%]\\n1*2%3"));
    }

}
