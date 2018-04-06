package com.m3c.as.sorters;

import java.util.ArrayList;

public class MergeSort implements Sorter {

    public int[] sortArray(int[] array) {
        int left[];
        int right[];

        if (array.length <= 1) {
            return array;
        }

        if (array.length % 2 == 0) {
            left = new int[array.length / 2];
            right = new int[array.length / 2];
        } else {
            left = new int[array.length / 2];
            right = new int[array.length / 2 + 1];
        }

        for (int i = 0; i < array.length; i++) {
            if (i < (array.length / 2)) {
                left[i] = array[i];
            } else {
                right[i - array.length / 2] = array[i];
            }
        }

        left = sortArray(left);
        right = sortArray(right);
        //System.out.println("Left: " + Arrays.toString(left));
        //System.out.println("Right: " + Arrays.toString(right));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        int resultIndex = 0;

        while (lIndex < left.length && rIndex < right.length) {
            if (left[lIndex] <= right[rIndex]) {
                result[resultIndex] = left[lIndex];
                lIndex++;
                resultIndex++;
            } else {
                result[resultIndex] = right[rIndex];
                rIndex++;
                resultIndex++;
            }
        }

        while (lIndex < left.length) {
            result[resultIndex] = left[lIndex];
            lIndex++;
            resultIndex++;
        }
        while (rIndex < right.length) {
            result[resultIndex] = right[rIndex];
            rIndex++;
            resultIndex++;
        }

        //System.out.println("Result: " + Arrays.toString(result));
        return result;
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}