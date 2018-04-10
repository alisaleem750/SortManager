package com.m3c.as.controller;

import com.m3c.as.sorters.BubbleSort;
import com.m3c.as.sorters.MergeSort;
import com.m3c.as.sorters.Sorter;
import com.m3c.as.sorters.binarytree.BinaryTreeSort;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SortFactory {

    private static final String SORTER_NOT_FOUND = "Sorry! Chosen sorter does not exist";
    private static final String NO_SORTER_CHOSEN = "No sorter selected in the factory.properties file!";
    private static final String FILE_NOT_FOUND = "Sorry! File not found";


    public static Sorter getInstance() throws SortManagerException {
        Properties properties = new Properties();
        try (FileReader fr = new FileReader("resources/factory.properties")) {
            properties.load(fr);
            String sorter = properties.getProperty("sorter");
            if(sorter==null){
                sorter="null";
            }
            switch (sorter) {
                case "null":
                    throw new SortManagerException(NO_SORTER_CHOSEN);
                case "bubble":
                    return new BubbleSort();
                case "merge":
                    return new MergeSort();
                case "binary":
                    return new BinaryTreeSort();
                default:
                    throw new SortManagerException(SORTER_NOT_FOUND);
            }
        } catch (IOException e) {
            throw new SortManagerException(FILE_NOT_FOUND);
        }
    }
}
