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

    @Test
    public void testInsertAfter()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        linkedList.insertAfter(2, "insert obj");
        assertEquals(5, linkedList.size());
    }

    @Test
    public void testDelete()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        linkedList.delete(2);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void testGetFirst()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        assertEquals("obj 1", linkedList.first());
    }

    @Test
    public void testGetLast()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        assertEquals("obj 4", linkedList.last());
    }

    @Test
    public void testGetBefore()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        assertEquals("obj 2", linkedList.before(2));
    }

    @Test
    public void testGetAfter()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        assertEquals("obj 4", linkedList.after(2));
    }

    @Test
    public void testFind()
    {
        List objects = setupListObject();
        SingleLinkedList linkedList = new SingleLinkedList(objects);
        assertEquals("obj 3", linkedList.find("obj 3").getData());
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
