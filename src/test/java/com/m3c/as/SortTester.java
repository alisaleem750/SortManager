package com.m3c.as;

import com.m3c.as.sorters.BubbleSort;
import com.m3c.as.sorters.MergeSort;
import com.m3c.as.sorters.Sorter;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for both bubble sort and merge sort.
 */
public class SortTester {

    public Sorter bubbleSorter;
    public Sorter mergeSorter;

    @Before
    public void setup() {
        bubbleSorter = new BubbleSort();
        mergeSorter = new MergeSort();
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};
        int[] sortedArray = bubbleSorter.sortArray(emptyArray);
        assertEquals(0, sortedArray.length);

        emptyArray = new int[]{};
        sortedArray = mergeSorter.sortArray(emptyArray);
        assertEquals(0, sortedArray.length);
    }

    @Test
    public void testArraySorting() {
        int[] unsortedArray = {4, 3, 2, 1};
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        int[] testFinalArray = {1, 2, 3, 4};
        assertArrayEquals(testFinalArray, sortedArray);

        unsortedArray = new int[]{4, 3, 2, 1};
        sortedArray = mergeSorter.sortArray(unsortedArray);
        testFinalArray = new int[]{1, 2, 3, 4};
        assertArrayEquals(testFinalArray, sortedArray);
    }

    @Test(expected = NullPointerException.class)
    public void testArrayNotNull() {
        bubbleSorter.sortArray(null);
        mergeSorter.sortArray(null);
    }

    @Test
    public void testOddSizedArray(){
        int[] unsortedArray = {5,3,2,1,4};
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        int[] testFinalArray= {1,2,3,4,5};
        assertArrayEquals(testFinalArray, sortedArray);

        unsortedArray = new int[]{5,3,2,1,4};
        sortedArray = mergeSorter.sortArray(unsortedArray);
        testFinalArray= new int[]{1,2,3,4,5};
        assertArrayEquals(testFinalArray, sortedArray);
    }
}
