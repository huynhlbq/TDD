package com.qs.tdd;

import java.lang.String;

/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculator
{
    public static int add(String numbers)
    {
        if (numbers.isEmpty())
        {
            return 0;
        }
        return Integer.parseInt(numbers);
    }
}
