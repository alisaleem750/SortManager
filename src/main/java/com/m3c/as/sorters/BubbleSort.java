package com.m3c.as.sorters;

/**
 * This class implements the Sorter interface and sorts arrays using the bubble sort algorithm.
 */
public class BubbleSort implements Sorter{

    /**
     * Sorts the array of integers passed in.
     * @param array list to be sorted
     * @return sorted array
     */
    public int[] sortArray(int[] array){
        boolean sorted = false;

        while (!sorted){
            sorted = true;
            for(int i=0;i<array.length-1;i++){
                if(array[i]>array[i+1]){
                    int temp = array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                    sorted=false;
                }
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
