package com.m3c.as.sorters.binarytree;

/**
 * This class represents a single node in a Binary Tree.
 */
public class Node {

    private final int value;
    private Node leftChild;
    private Node rightChild;

    /**
     * Constructor for Node. Assigns the value of the node at creation.
     * @param value int representing value of node.
     */
    public Node(int value){
        this.value = value;
    }

    /**
     * Getter to get the value of this node
     * @return int value of node
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the left child Node of this Node.
     * @return Node left child
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * Gets the right child Node of this Node.
     * @return Node right child
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * Sets the left child Node for this Node.
     * @param leftChild Node to be assigned as left child
     */
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Sets the right child Node for this Node.
     * @param rightChild Node to be assigned as right child
     */
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Removes the left child Node of this Node.
     * @return Node removed.
     */
    public Node removeLeftChild(){
        Node child;
        child = getLeftChild();
        setLeftChild(null);
        return child;
    }

    /**
     * Removes the right child Node of this Node
     * @return Node removed.
     */
    public Node removeRightChild(){
        Node child;
        child = getRightChild();
        setRightChild(null);
        return child;
    }

    /**
     * Returns true if there is no left child for this Node, false otherwise.
     * @return boolean
     */
    public boolean isLeftChildEmpty(){
        if (leftChild == null){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Returns true if there no right child for this Node, false otherwise
     * @return boolean
     */
    public boolean isRightChildEmpty(){
        if (rightChild == null){
            return true;
        } else{
            return false;
        }
    }
}
