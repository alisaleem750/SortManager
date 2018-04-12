package com.m3c.as.controller;
/**
 * The SortManager program implements different sorters (Binary tree, merge sort, bubble sort) to sort lists, displaying
 * the result to the standard output.
 *
 * This is the starter/Main class
 *
 * @author Ali Saleem
 * @version 1.0
 * @since 6/04/2018
 */
public class Main
{
    public static void main( String[] args )
    {
        SortManager sorter = new SortManager();
        sorter.initialiseLogging();
        sorter.sortArray();
    }
}
