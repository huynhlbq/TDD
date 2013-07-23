package com.qs.tdd;

/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculator
{
    private static final String DEFAULT_DELIMITER_REGEX = ",|\n";

    public static int add(String numbers)
    {
        if (numbers.isEmpty())
        {
            return 0;
        }

        int total = 0;
        for (String param : numbers.split(DEFAULT_DELIMITER_REGEX))
        {
            int paramNumber = Integer.parseInt(param);
            total += paramNumber;
        }
        return total;
    }
}
