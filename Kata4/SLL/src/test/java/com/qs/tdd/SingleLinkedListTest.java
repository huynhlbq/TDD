package com.qs.tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    @SuppressWarnings("unchecked")
    public void testCreatedListFromArrayOfObject()
    {
        List objects = new ArrayList();
        objects.add(12);
        objects.add("test");
        objects.add("end");
        SingleLinkedList linkedList = new SingleLinkedList(objects.toArray());
        assertEquals(3, linkedList.size());
    }

}
