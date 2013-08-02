package com.qs.tdd;

/**
 * User: Hunter
 * Date: 8/2/13
 */
public class Node
{
// ------------------------------ FIELDS ------------------------------

    private Node next;
    private Node previous;
    private Object data;

// --------------------------- CONSTRUCTORS ---------------------------

    Node(Node next, Node previous, Object data)
    {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public Node getPrevious()
    {
        return previous;
    }

    public void setPrevious(Node previous)
    {
        this.previous = previous;
    }
}
