package com.m3c.as.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SortManagerException extends Exception {
    private static final Logger logger = LogManager.getLogger("myLogger");

    public SortManagerException(String message) {
        super(message);
        logger.error(super.getMessage());
    }
}
