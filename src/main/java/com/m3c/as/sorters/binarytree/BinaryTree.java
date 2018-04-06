package com.m3c.as.sorters.binarytree;

import com.m3c.as.controller.ElementNotFoundException;

import java.util.List;

public interface BinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ElementNotFoundException;

    int getRightChild(int element) throws ElementNotFoundException;

    List<Integer> getSortedTreeAsc();

    List<Integer> getSortedTreeDesc();
}
