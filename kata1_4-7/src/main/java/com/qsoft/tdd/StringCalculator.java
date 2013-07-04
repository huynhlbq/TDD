package com.qsoft.tdd;

/**
 * User: Hunter
 * Date: 7/4/13
 */
public class StringCalculator
{
    private static final String DELIMITER = "(,|\n|;|\\*|\\]|\\[|\\/)";

    public int add(String numbers) throws Exception
    {
        if (numbers.isEmpty())
        {
            return 0;
        }

        int total = 0;
        for (String param : numbers.split(DELIMITER))
        {
            if (numbers.contains("-"))
            {
                throw new Exception("negatives not allowed");
            }

            if (!param.isEmpty())
            {
                int number = Integer.parseInt(param);
                if (number < 1000)
                {
                    total += number;
                }
            }
        }
        return total;
    }
}
