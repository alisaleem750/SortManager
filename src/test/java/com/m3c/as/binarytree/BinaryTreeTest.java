package com.m3c.as.binarytree;

import com.m3c.as.controller.ElementNotFoundException;
import com.m3c.as.controller.JustRootItemException;
import com.m3c.as.controller.SortManagerException;
import com.m3c.as.sorters.binarytree.BinaryTree;
import com.m3c.as.sorters.binarytree.BinaryTreeImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    int root;
    BinaryTreeImpl bt;

    @Before
    public void setup() {
        root = 7;
        bt = new BinaryTreeImpl(root);
    }


    @Test
    public void instantiateWithArrayTest(){
        int[] array = {7,1,8,5,6,3,12};
        bt = new BinaryTreeImpl(array);
        assertEquals(array.length, bt.getNumberOfElements());
    }

    @Test
    public void getRootElementTest() {
        assertEquals(root, bt.getRootElement());
    }

    @Test
    public void getNumberOfElementsTest() {
        int[] list = {3, 1, 2};

        assertEquals(1, bt.getNumberOfElements());
        bt.addElements(list);
        assertEquals((1 + list.length), bt.getNumberOfElements());
    }

    @Test
    public void addElementTest() throws ElementNotFoundException {
        int element1 = 3;
        int element2 = 10;

        assertEquals(1, bt.getNumberOfElements());
        bt.addElement(element1);
        assertEquals(2, bt.getNumberOfElements());
        assertEquals(element1, bt.getLeftChild(bt.getRootElement()));
        bt.addElement(element2);
        assertEquals(3, bt.getNumberOfElements());
        assertEquals(element2, bt.getRightChild(bt.getRootElement()));
    }

    @Test
    public void addElementsTest() throws ElementNotFoundException {
        int[] list = {3, 1, 9};

        assertEquals(1, bt.getNumberOfElements());
        bt.addElements(list);
        assertEquals((1 + list.length), bt.getNumberOfElements());
        assertEquals(3, bt.getLeftChild(bt.getRootElement()));
        assertEquals(9, bt.getRightChild(bt.getRootElement()));
        assertEquals(1, bt.getLeftChild(bt.getLeftChild(bt.getRootElement())));
    }

    @Test
    public void findElementsTest() {
        int value = 2;
        assertFalse(bt.findElement(value));
        bt.addElement(value);
        assertTrue(bt.findElement(value));
    }

    @Test
    public void getLeftChildTest() throws ElementNotFoundException {
        int value = 3;
        bt.addElement(value);
        assertEquals(value, bt.getLeftChild(bt.getRootElement()));
        bt.addElements(new int[]{9, 8});
        assertEquals(8, bt.getLeftChild(9));
    }

    @Test(expected = ElementNotFoundException.class)
    public void getEmptyLeftChildTest() throws ElementNotFoundException {
        int value = 1;
        assertEquals(value, bt.getLeftChild(bt.getRootElement()));
    }

    @Test
    public void getRightChildTest() throws ElementNotFoundException {
        int value = 10;
        bt.addElement(value);
        assertEquals(value, bt.getRightChild(bt.getRootElement()));
        bt.addElements(new int[] {8,9});
        assertEquals(9, bt.getRightChild(8));
    }

    @Test(expected = ElementNotFoundException.class)
    public void getEmptyRightChildTest() throws ElementNotFoundException {
        int value = 8;
        assertEquals(value, bt.getRightChild(bt.getRootElement()));
    }

    @Test
    public void getSortedTreeAsc() {
        int[] unsorted = {2, 4, 1, 5, 7};
        int[] sorted = {1,2,4,5,7};
        List<Integer> sortedTreeAsc;

        bt.addElements(unsorted);
        sortedTreeAsc = bt.getSortedTreeAsc();
        assertArrayEquals(sorted, sortedTreeAsc.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void getSortedTreeDesc(){
        int[] unsorted = {2, 4, 1, 5, 7};
        int[] sorted = {7,5,4,2,1};
        List<Integer> sortedTreeDesc;

        bt.addElements(unsorted);
        sortedTreeDesc = bt.getSortedTreeDesc();

        assertArrayEquals(sorted, sortedTreeDesc.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void deleteNodeTest() throws ElementNotFoundException, JustRootItemException {
        int[] unsorted = {1, 8, 5, 3, 6, 12};

        bt.addElements(unsorted);
        assertEquals(1, bt.getLeftChild(7));
        bt.deleteNode(7);
        assertEquals(1, bt.getLeftChild(6));
        assertEquals(8, bt.getRightChild(6));
        bt.deleteNode(8);
        assertEquals(12, bt.getRightChild(6));
        bt.deleteNode(1);
        assertEquals(3, bt.getLeftChild(6));
        bt.deleteNode(3);
        assertEquals(5, bt.getLeftChild(6));
        bt.deleteNode(5);
        assertEquals(5, bt.getLeftChild(6));
    }

    @Test(expected = JustRootItemException.class)
    public void cannotDeleteRootNodeWith1ItemInTreeTest() throws JustRootItemException {
        int rootToDelete = bt.getRootElement();
        bt.deleteNode(rootToDelete);
    }
}
