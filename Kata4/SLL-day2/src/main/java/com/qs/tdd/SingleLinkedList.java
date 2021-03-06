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

// -------------------------- OTHER METHODS --------------------------

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

    public Node get(int index)
    {
        return entry(index);
    }

    public void insertAfter(int index, Object o)
    {
        insertBefore(o, (index == size ? header : entry(index)));
    }

    private void insertBefore(Object o, Node node)
    {
        Node insertNode = new Node(node, node.getPrevious(), o);
        insertNode.getPrevious().setNext(insertNode);
        insertNode.getNext().setPrevious(insertNode);
        size++;
    }

    public int size()
    {
        return size;
    }

    public void delete(int index)
    {
        Node deleteNode = entry(index);
        deleteNode.getPrevious().setNext(deleteNode.getNext());
        deleteNode.getNext().setPrevious(deleteNode.getPrevious());
        deleteNode.setNext(null);
        deleteNode.setPrevious(null);
        deleteNode.setData(null);
        size--;
    }

    public Object first()
    {
        return header.getNext().getData();
    }

    public Object last()
    {
        return header.getPrevious().getData();
    }

    public Object before(int index)
    {
        return entry(index).getPrevious().getData();
    }

    public Object after(int index)
    {
        return entry(index).getNext().getData();
    }

    public Node find(Object o)
    {
        for (int i = 0; i < size; i++)
        {
            if (entry(i).getData().equals(o))
            {
                return entry(i);
            }
        }
        return null;
    }

    public void append(Object appendedNode)
    {
        Node insertNode = new Node(header, header.getPrevious(), appendedNode);
        insertNode.getPrevious().setNext(insertNode);
        insertNode.getNext().setPrevious(insertNode);
        size++;
    }

    public void insertFirst(Object insertedObject)
    {
        Node insertNode = new Node(header.getNext(), header, insertedObject);
        insertNode.getPrevious().setNext(insertNode);
        insertNode.getNext().setPrevious(insertNode);
        size++;
    }
}
