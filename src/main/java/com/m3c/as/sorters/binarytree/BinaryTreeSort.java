package com.m3c.as.sorters.binarytree;

import com.m3c.as.sorters.Sorter;

/**
 * This class standardizes the binary tree implementation to the Sorter interface for a more uniform access from the controller.
 */
public class BinaryTreeSort implements Sorter{

    /**
     * Sorts the array of integers passed in.
     * @param array list to be sorted
     * @return sorted array
     */
    @Override
    public int[] sortArray(int[] array) {
        int[] result;

        BinaryTree bt = new BinaryTreeImpl(array);
        result = bt.getSortedTreeAsc().stream().mapToInt(i -> i).toArray();

        return result;
    }

    @Override
    public String toString() {
        return "Binary sort";
    }
}
