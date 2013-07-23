package com.qs.tdd;

import java.lang.String;

/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculator
{
    private static final String DEFAULT_DELIMITER_REGEX = ",|\n";
    private static final String CUSTOM_DEFINE = "//";

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
            if (!aNumbersString.isEmpty())
            {
                total += string2Int(aNumbersString);
            }
        }
        return total;
    }

    private static int string2Int(String s)
    {
        return Integer.parseInt(s);
    }

    private static String[] tokenizer(String numbers)
    {
        if (numbers.startsWith(CUSTOM_DEFINE))
        {
            return splitByCustomDefine(numbers);
        }
        return numbers.split(DEFAULT_DELIMITER_REGEX);
    }

    private static String[] splitByCustomDefine(String numbers)
    {
        String customSplit = numbers.substring(CUSTOM_DEFINE.length(), CUSTOM_DEFINE.length() + 1);
        String tmp = numbers.substring(CUSTOM_DEFINE.length() + 1);
        return tmp.split(customSplit + "|" + DEFAULT_DELIMITER_REGEX);
    }
}
