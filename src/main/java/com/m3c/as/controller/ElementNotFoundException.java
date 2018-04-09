package com.m3c.as.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ElementNotFoundException extends Exception {

    private static final Logger logger = LogManager.getLogger("myLogger");

    public ElementNotFoundException(){
        super("Element not found");
        logger.error(super.getMessage());
    }
}
