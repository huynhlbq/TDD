package com.qs.tdd;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * User: Hunter
 * Date: 8/1/13
 */
public class SingleLinkedListTest
{
    @Test
    public void testCreatedEmptyList()
    {
        SingleLinkedList linkedList = new SingleLinkedList();
        assertEquals(0, linkedList.size());
    }

}
