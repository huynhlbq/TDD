package com.qsoft.tdd;

/**
 * User: Hunter
 * Date: 7/5/13
 */
public class StringCalculator
{
    private static final String DELIMITER_REGEX = ",|\n|\\/|;|\\*|\\[|\\]|%";

    public int add(String numberText) throws NegativeNumberNotAllowedException
    {
        if (numberText.isEmpty())
        {
            return 0;
        }
        int total = 0;
        for (String param : numberText.split(DELIMITER_REGEX))
        {
            //ignore delimiter
            if (!param.isEmpty())
            {
                int paramNumber = Integer.parseInt(param);
                if (paramNumber < 0)
                {
                    throw new NegativeNumberNotAllowedException("negatives not allowed");
                }
                if (paramNumber <= 1000)
                {
                    total += paramNumber;
                }
            }
        }
        return total;
    }
}
