package com.m3c.as.controller;

/**
 * Exception class to handle exceptions when an attempt is made to remove a node from the
 * binary tree when only 1 item (the root) is present in the tree.
 */
public class JustRootItemException extends Exception{

    public JustRootItemException(){
        super("Root element cannot be removed with only 1 item in the binary tree");
    }
}
