package com.m3c.as.controller;

public class JustRootItemException extends Exception{

    public JustRootItemException(){
        super("Root element cannot be removed with only 1 item in the binary tree");
    }
}
