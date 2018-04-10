package com.m3c.as.controller;

public class Main
{
    public static void main( String[] args )
    {
        SortManager sorter = new SortManager();
        sorter.initialiseLogging();
        sorter.sortArray();
    }
}
