package com.m3c.as.sorters.binarytree;

public class Node {

    private final int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int root){
        this.value = root;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node removeLeftChild(){
        Node child;
        child = getLeftChild();
        setLeftChild(null);
        return child;
    }

    public Node removeRightChild(){
        Node child;
        child = getRightChild();
        setRightChild(null);
        return child;
    }

    public boolean isLeftChildEmpty(){
        if (leftChild == null){
            return true;
        } else{
            return false;
        }
    }

    public boolean isRightChildEmpty(){
        if (rightChild == null){
            return true;
        } else{
            return false;
        }
    }
}
