package com.qs.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Hunter
 * Date: 8/1/13
 */
public class SingleLinkedList
{
    private List<Node> nodes = new ArrayList<Node>();

    public SingleLinkedList(List<Node> nodes)
    {
        this.nodes = nodes;
    }

    public SingleLinkedList()
    {
    }

    public int size()
    {
        return nodes.size();
    }
}
