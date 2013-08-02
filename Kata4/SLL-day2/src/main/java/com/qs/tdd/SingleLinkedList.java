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

    private boolean addAll(List objects)
    {
        return addAll(size, objects);
    }

    /**
     * add all objects from index
     *
     * @param index
     * @param objects
     * @return
     */
    private boolean addAll(int index, List objects)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (objects.size() == 0)
        {
            return false;
        }
        Node successor = (index == size ? header : entry(index));
        Node predecessor = successor.getPrevious();
        for (Object o : objects)
        {
            Node e = new Node(successor, predecessor, o);
            predecessor.setNext(e);
            predecessor = e;
        }
        successor.setPrevious(predecessor);

        size += objects.size();
        return true;
    }

    public Node get(int index)
    {
        return entry(index);
    }

    private Node entry(int index)
    {
        Node e = header;
        if (index < (size >> 1))
        {
            for (int i = 0; i <= index; i++)
            {
                e = e.getNext();
            }
        }
        else
        {
            for (int i = size; i > index; i--)
            {
                e = e.getPrevious();
            }
        }
        return e;
    }

// -------------------------- OTHER METHODS --------------------------

    public int size()
    {
        return size;
    }
}
