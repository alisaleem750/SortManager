package com.m3c.as.view;

import com.m3c.as.sorters.Sorter;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * This class handles everything that needs to be displayed to the standard output.
 */
public class SortDisplayManager {

    public void displaySorterUsed(Sorter sorter){
        System.out.println("Sorter Used: " + sorter.toString());
    }

    public void displayUnsortedArray(int[] array){
        System.out.println("Unsorted Array: " + Arrays.toString(array));
    }

    public void displaySortedArray(int[] array){
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public void displayTime(long start, long end){
        DecimalFormat df = new DecimalFormat( "###,###.####");
        System.out.println("Time taken: " + df.format((end-start)));
    }

    public void displayException(String msg){
        System.out.println(msg);
    }
}
