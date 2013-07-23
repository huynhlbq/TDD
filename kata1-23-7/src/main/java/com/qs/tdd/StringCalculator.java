package com.qs.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculator
{
    private static final String DEFAULT_DELIMITER_REGEX = ",|\n";
    private static final String CUSTOM_DEFINE = "//";

    public static int add(String numbers) throws NegativeNumberNotAllowedException
    {
        String delimiter = DEFAULT_DELIMITER_REGEX;
        if (numbers.isEmpty())
        {
            return 0;
        }

        if (numbers.startsWith(CUSTOM_DEFINE))
        {
            String customDefineDelimiter = numbers.substring(CUSTOM_DEFINE.length(), CUSTOM_DEFINE.length() + 1);
            delimiter += "|" + customDefineDelimiter;
            numbers = numbers.substring(numbers.lastIndexOf("\n"));
        }

        int total = 0;
        String negativeString = "";
        for (String param : numbers.split(delimiter))
        {
            if (param.isEmpty())
            {
                continue;
            }
            int paramNumber = Integer.parseInt(param);
            if (paramNumber > 1000)
            {
                continue;
            }
            if (paramNumber < 0)
            {
                if (!negativeString.isEmpty())
                {
                    negativeString += "; ";
                }
                negativeString += param;
            }
            total += paramNumber;
        }
        if (!negativeString.isEmpty())
        {
            throw new NegativeNumberNotAllowedException("negatives not allowed: " + negativeString);
        }
        return total;
    }
}
