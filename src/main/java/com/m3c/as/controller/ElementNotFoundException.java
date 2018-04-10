package com.m3c.as.controller;

/**
 * Exception class to handle exceptions when an element in a Binary Tree is not found.
 */
public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(){
        super("Element not found");
    }
}
