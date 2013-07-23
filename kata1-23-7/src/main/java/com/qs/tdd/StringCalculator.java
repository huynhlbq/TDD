package com.qs.tdd;

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
        for (String param : numbers.split(delimiter))
        {
            if (param.isEmpty())
            {
                continue;
            }
            int paramNumber = Integer.parseInt(param);
            total += paramNumber;
        }
        return total;
    }
}
