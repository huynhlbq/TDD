package com.qsoft.tdd;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

/**
 * User: Hunter
 * Date: 7/5/13
 */
public class StringCalculatorTest
{
    @Test
    public void addEmptyStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addOneStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("2"));
    }

    @Test
    public void addMultiParamsStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.add("1,2,3,4"));
    }

    @Test
    public void addWithLineBreakStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void addDelimiterStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addNegativeStringTest() throws Exception
    {
        expectedException.expect(NegativeNumberNotAllowedException.class);
        expectedException.expectMessage("negatives not allowed");
        StringCalculator calculator = new StringCalculator();
        calculator.add("1;-2");
    }

    @Test
    public void addIgnore1001StringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    public void addMoreDelimiterStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void addDefinedDelimitersStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }
    @Test
    public void addMoreDelimitersStringTest() throws Exception
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***]\n1***2*%**3"));
    }
}
