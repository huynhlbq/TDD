package com.qs.tdd;

import java.util.Collection;
import java.util.List;

/**
 * User: Hunter
 * Date: 8/1/13
 */
public class SingleLinkedList
{
    private Node header = new Node(null, null, null);
    private int size = 0;

    public SingleLinkedList(Object[] objects)
    {
        this();
        addAll(objects);
    }

    private void addAll(Object[] objects)
    {
        Node insertNode = header;
        for (int i = 0; i < objects.length; i++)
        {
            Node e = new Node(insertNode, null, objects[i]);
            insertNode.next = e;
            e.previous = insertNode;
            insertNode = e;
        }
        size += objects.length;
    }

    public SingleLinkedList()
    {
        header.next = header.previous = header;
    }

    public int size()
    {
        return size;
    }

    private static class Node
    {
        private Node next;
        private Node previous;
        private Object data;

        Node(Node next, Node previous, Object data)
        {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }
    }
}
