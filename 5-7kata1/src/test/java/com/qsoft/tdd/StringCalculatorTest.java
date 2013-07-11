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
        
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void addOneStringTest() throws Exception
    {
        
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void addMultiParamsStringTest() throws Exception
    {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void addWithLineBreakStringTest() throws Exception
    {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void addDelimiterStringTest() throws Exception
    {
        
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addNegativeStringTest() throws Exception
    {
        expectedException.expect(NegativeNumberNotAllowedException.class);
        expectedException.expectMessage("negatives not allowed");
        StringCalculator.add("1;-2");
    }

    @Test
    public void addIgnore1001StringTest() throws Exception
    {
        
        assertEquals(2, StringCalculator.add("2,1001"));
    }

    @Test
    public void addMoreDelimiterStringTest() throws Exception
    {
        
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void addDefinedDelimitersStringTest() throws Exception
    {
        
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }
    @Test
    public void addMoreDelimitersStringTest() throws Exception
    {
        
        assertEquals(6, StringCalculator.add("//[***][#####]\n1***2#####3"));
    }
}
