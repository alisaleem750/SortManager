package com.m3c.as.controller;


import com.m3c.as.sorters.Sorter;
import com.m3c.as.view.SortDisplayManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;


public class SortManager {
    private static final Logger logger = LogManager.getLogger("myLogger");

    Sorter sorter;
    int[] array;
    SortDisplayManager display;

    public SortManager() {
        display = new SortDisplayManager();
        try {
            sorter = SortFactory.getInstance();
            array = createArray(10);
        } catch (SortManagerException sme) {
            display.displayException(sme.getMessage());
        }
    }

    public void sortArray() {
        if(sorter != null) {
            display.displaySorterUsed(sorter);
            display.displayUnsortedArray(array);
            long start = System.nanoTime();
            array = sorter.sortArray(this.array);
            long end = System.nanoTime();
            display.displaySortedArray(array);
            display.displayTime(start, end);
        }
    }

    private int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size * 10) + 1;
        }
        return unsortedArray;
    }
}
