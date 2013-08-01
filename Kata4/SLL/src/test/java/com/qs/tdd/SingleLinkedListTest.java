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
    private static final int CONSTANT = 10;

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
        List<Node> nodes = setupListNode();
        SingleLinkedList linkedList = new SingleLinkedList(nodes);
        assertEquals(CONSTANT, linkedList.size());
    }

    private List<Node> setupListNode()
    {
        List<Node> results = new ArrayList<Node>();
        for (int i = 0; i < CONSTANT; i++)
        {
            Node node = new Node();
            node.setValue("node " + i);
            if (i < CONSTANT - 1)
            {
                node.setNext(i + 1);
            }
            results.add(node);
        }
        return results;
    }

}
