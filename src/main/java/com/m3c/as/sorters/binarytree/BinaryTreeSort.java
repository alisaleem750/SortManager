package com.m3c.as.sorters.binarytree;

import com.m3c.as.sorters.Sorter;

import java.util.List;

public class BinaryTreeSort implements Sorter{

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
