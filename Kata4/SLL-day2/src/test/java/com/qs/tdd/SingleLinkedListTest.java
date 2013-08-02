package com.qs.tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
/**
 * User: Hunter
 * Date: 8/2/13
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
    public void testCreatedListFromArrayOfObject()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        assertEquals(4, linkedList.size());
    }

    @SuppressWarnings("unchecked")
    private List setupListObject()
    {
        List results = new ArrayList();
        results.add("obj 1");
        results.add("obj 2");
        results.add("obj 3");
        results.add("obj 4");
        return results;
    }
}
