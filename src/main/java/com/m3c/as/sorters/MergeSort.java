package com.m3c.as.sorters;

/**
 * This class implements the Sorter interface and sorts arrays using the merge sort algorithm.
 */
public class MergeSort implements Sorter {

    /**
     * Sorts the array of integers passed in.
     * @param array list to be sorted
     * @return sorted array
     */
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
        return merge(left, right);
    }

    /**
     * Takes in two arrays, and merges them into a single sorted array.
     * @param left sub-array left half of array
     * @param right sub-array right half of array
     * @return array combining values of left and right arrays by sorting them.
     */
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
        return result;
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}