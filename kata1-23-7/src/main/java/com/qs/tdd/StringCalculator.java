package com.qs.tdd;

import java.lang.String;

/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculator
{
    private static final String DEFAULT_DELIMITER_REGEX = ",";

    public static int add(String numbers)
    {
        if (numbers.isEmpty())
        {
            return 0;
        }
        String[] numbersString = tokenizer(numbers);
        int total = 0;
        for (String aNumbersString : numbersString)
        {
            total += string2Int(aNumbersString);
        }
        return total;
    }

    private static int string2Int(String s)
    {
        return Integer.parseInt(s);
    }

    private static String[] tokenizer(String numbers)
    {
        return numbers.split(DEFAULT_DELIMITER_REGEX);
    }
}
