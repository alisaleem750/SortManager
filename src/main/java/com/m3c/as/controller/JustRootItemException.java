package com.m3c.as.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class JustRootItemException extends Exception{

    private static final Logger logger = LogManager.getLogger("myLogger");

    public JustRootItemException(){
        super("Root element cannot be removed with only 1 item in the binary tree");
        logger.error(super.getMessage());
    }
}
