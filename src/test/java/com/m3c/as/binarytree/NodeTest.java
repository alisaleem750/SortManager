package com.m3c.as.binarytree;

import com.m3c.as.controller.ElementNotFoundException;
import com.m3c.as.sorters.binarytree.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Node in a binary tree.
 */
public class NodeTest {

    Node node;

    @Before
    public void setup(){
        node = new Node(5);
    }

    @Test
    public void getNodeValueTest(){
        assertEquals(5, node.getValue());
    }

    @Test
    public void setGetLeftChildNodeTest() throws ElementNotFoundException {
        Node leftChild = new Node(3);
        node.setLeftChild(leftChild);
        assertEquals(leftChild, node.getLeftChild());
    }

    @Test
    public void setGetRightChildNodeTest() throws ElementNotFoundException {
        Node rightChild = new Node (7);
        node.setRightChild(rightChild);
        assertEquals(rightChild, node.getRightChild());
    }

    @Test
    public void isLeftChildEmptyTest(){
        assertTrue(node.isLeftChildEmpty());
        node.setLeftChild(new Node(2));
        assertFalse(node.isLeftChildEmpty());
    }

    @Test
    public void isRightChildEmptyTest(){
        assertTrue(node.isRightChildEmpty());
        node.setRightChild(new Node(10));
        assertFalse(node.isRightChildEmpty());
    }

    @Test
    public void removeLeftChildTest(){
        node.setLeftChild(new Node(2));
        assertFalse(node.isLeftChildEmpty());
        node.removeLeftChild();
        assertTrue(node.isLeftChildEmpty());
    }

    @Test
    public void removeRightChildTest(){
        node.setRightChild(new Node(10));
        assertFalse(node.isRightChildEmpty());
        node.removeRightChild();
        assertTrue(node.isRightChildEmpty());
    }
}
