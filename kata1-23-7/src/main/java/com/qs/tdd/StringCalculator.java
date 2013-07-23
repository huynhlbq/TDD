package com.qs.tdd;

import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Hunter
 * Date: 7/23/13
 */
public class StringCalculator
{
    private static final String DEFAULT_DELIMITER_REGEX = ",|\n";
    private static final String CUSTOM_DELIMITER_PATTERN = "//((.)|\\[(.*?)\\])\\n";
    private static final String CUSTOM_DEFINE = "//";
    private static final String SEPARATOR = "; ";

    public static int add(String numbers) throws NegativeNumberNotAllowedException
    {
        if (numbers.isEmpty())
        {
            return 0;
        }
        String[] numbersString = tokenizer(numbers);
        int total = 0;
        String negativeNumberString = "";
        for (String aNumbersString : numbersString)
        {
            if (!aNumbersString.isEmpty())
            {
                int aNumber = string2Int(aNumbersString);
                if (aNumber < 0)
                {
                    if (!negativeNumberString.isEmpty())
                    {
                        negativeNumberString += SEPARATOR;
                    }
                    negativeNumberString += aNumbersString;
                }
                else if (aNumber < 1001)
                {
                    total += aNumber;
                }
            }
        }
        if (!negativeNumberString.isEmpty())
        {
            throw new NegativeNumberNotAllowedException("negatives not allowed: " + negativeNumberString);
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
        Pattern p = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher m = p.matcher(numbers);

        String delimiter;
        String toSplit = "";
        String[] delimiters = new String[0];
        while (m.find())
        {
            delimiter = m.group(1);
            delimiters = delimiter.split("\\]|\\[");
        }
        for (String delimiterString : delimiters)
        {
            if (!delimiterString.isEmpty())
            {
                toSplit += Pattern.quote(delimiterString) + "|";
            }
        }

        numbers = numbers.substring(numbers.indexOf("\n") + 1);
        return numbers.split(toSplit);
    }
}
