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
    public void addEmptyStringTest()
    {
        assertEquals(0, StringCalculator.add(""));
    }
}
