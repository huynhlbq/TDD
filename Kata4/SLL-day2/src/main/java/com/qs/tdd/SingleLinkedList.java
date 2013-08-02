package com.qs.tdd;

import java.util.List;

/**
 * User: Hunter
 * Date: 8/2/13
 */
public class SingleLinkedList
{
// ------------------------------ FIELDS ------------------------------

    //header node
    private Node header = new Node(null, null, null);
    private int size = 0;

// --------------------------- CONSTRUCTORS ---------------------------

    public SingleLinkedList()
    {
        header.setNext(header);
        header.setPrevious(header);
    }

    public SingleLinkedList(List objects)
    {
        this();
        addAll(objects);
    }

// -------------------------- OTHER METHODS --------------------------

    public int size()
    {
        return size;
    }
}
