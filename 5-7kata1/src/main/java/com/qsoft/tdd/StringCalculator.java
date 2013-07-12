package com.qsoft.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Hunter
 * Date: 7/5/13
 */
public class StringCalculator
{
    private static final String DELIMITER_REGEX = ",|\n|\\/|;";
    private static final String DEFINED_GROUP_DELIMITER_REGEX = "\\[(.*?)\\]";

    public static int add(String numberText) throws NegativeNumberNotAllowedException
    {
        if (numberText.isEmpty())
        {
            return 0;
        }
        for(String definedDelimiter : getDefinedDelimiters(numberText))
        {
            definedDelimiter = Pattern.quote(definedDelimiter);
//            remove all defined on start
            numberText = numberText.replaceAll("\\[" + definedDelimiter + "\\]", "");
//            replace all customer define delimiter by standard delimiter
            numberText = numberText.replaceAll(definedDelimiter, ",");
        }

        int total = 0;
        for (String param : numberText.split(DELIMITER_REGEX))
        {
            //ignore multiple delimiter if they come together
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

    private static List<String> getDefinedDelimiters(String input)
    {
        List<String> delimiters = new ArrayList<String>();
        Pattern pattern = Pattern.compile(DEFINED_GROUP_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
        {
            delimiters.add(matcher.group(1));
        }
        return delimiters;
    }
}
