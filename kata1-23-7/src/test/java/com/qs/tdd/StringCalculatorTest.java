package com.qs.tdd;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculatorTest
{
    @Test
    public void testAddEmptyString() throws NegativeNumberNotAllowedException
    {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testAddOneNumber() throws NegativeNumberNotAllowedException
    {
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void testAddTwoNumbers() throws NegativeNumberNotAllowedException
    {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testNewLineBetweenNumbers() throws Exception
    {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test (expected = NumberFormatException.class)
    public void testWithInvalidInput() throws Exception
    {
        StringCalculator.add("1n,\n");
        expectedException.expectMessage("For input string: \"1n\"");
    }

    @Test
    public void testWithCustomDelimiter() throws Exception
    {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void addNegativeStringTest() throws Exception
    {
        expectedException.expect(NegativeNumberNotAllowedException.class);
        expectedException.expectMessage("negatives not allowed");
        StringCalculator.add("1,-2");
    }

}
