package com.qsoft.tdd;

/**
 * User: Hunter
 * Date: 7/3/13
 */
public class StringCalculator
{
    public int add(String numberToAdd) throws Exception
    {
        if (numberToAdd.equals(""))
        {
            return 0;
        }
        else
        {
            numberToAdd = numberToAdd.replaceAll("\\/", "");
            int total = 0;
            for(String param : numberToAdd.split("(,|\n|;)"))
            {
                if (!param.equals(""))
                {
                    if (Integer.parseInt(param) < 0)
                    {
                        throw new Exception("negatives not allowed");
                    }
                    total += Integer.parseInt(param);
                }
            }
            return total;
        }
    }
}
