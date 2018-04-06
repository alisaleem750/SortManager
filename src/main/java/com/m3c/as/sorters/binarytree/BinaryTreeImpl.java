package com.m3c.as.sorters.binarytree;

import com.m3c.as.controller.ElementNotFoundException;
import com.m3c.as.controller.JustRootItemException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreeImpl implements BinaryTree {

    private Node root;
    private int nodeCount;

    public BinaryTreeImpl(int value) {
        root = new Node(value);
        nodeCount = 1;
    }

    public BinaryTreeImpl(int[] values) {
        root = new Node(values[0]);
        int[] otherElements = Arrays.copyOfRange(values, 1, values.length);
        nodeCount = 1;
        addElements(otherElements);
    }


    public int getRootElement() {
        return root.getValue();
    }

    public int getNumberOfElements() {
        return nodeCount;
    }

    public void addElement(int element) {
        boolean elementAdded = findElement(element);
        Node currentNode = root;

        while (!elementAdded) {
            if (element > currentNode.getValue()) {
                if (currentNode.isRightChildEmpty()) {
                    currentNode.setRightChild(new Node(element));
                    nodeCount++;
                    elementAdded = true;
                } else {
                    currentNode = currentNode.getRightChild();
                }
            } else {
                if (currentNode.isLeftChildEmpty()) {
                    currentNode.setLeftChild(new Node(element));
                    nodeCount++;
                    elementAdded = true;
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            }
        }
    }

    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }

    }

    public boolean findElement(int value) {
        Node currentNode = root;

        while (currentNode != null) {
            if (value == currentNode.getValue()) {
                return true;
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild();
            }
        }
        return false;
    }

    public int getLeftChild(int element) throws ElementNotFoundException {
        Node currentNode = root;

        if (findElement(element)) {
            while (currentNode.getValue() != element) {
                if (element > currentNode.getValue()) {
                    currentNode = currentNode.getRightChild();
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            }
            if (!currentNode.isLeftChildEmpty()) {
                return currentNode.getLeftChild().getValue();
            }
        }
        throw new ElementNotFoundException();
    }

    public int getRightChild(int element) throws ElementNotFoundException {
        Node currentNode = root;
        if (findElement(element)) {
            while (currentNode.getValue() != element) {
                if (element > currentNode.getValue()) {
                    currentNode = currentNode.getRightChild();
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            }
            if (!currentNode.isRightChildEmpty()) {
                return currentNode.getRightChild().getValue();
            }
        }
        throw new ElementNotFoundException();
    }

    public void deleteNode(int element) throws JustRootItemException {
        Node parentNodeToRemove = null;
        Node nodeToRemove = root;
        Node parentNodeToMove = null;
        Node nodeToMove;
        if (findElement(element)) {
            while (nodeToRemove.getValue() != element) {
                if (element < nodeToRemove.getValue()) {
                    parentNodeToRemove = nodeToRemove;
                    nodeToRemove = nodeToRemove.getLeftChild();
                } else {
                    parentNodeToRemove = nodeToRemove;
                    nodeToRemove = nodeToRemove.getRightChild();
                }
            }
            if (!nodeToRemove.isLeftChildEmpty()) {
                nodeToMove = nodeToRemove.getLeftChild();
                if (!nodeToMove.isRightChildEmpty()) {
                    while (!nodeToMove.isRightChildEmpty()) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.getRightChild();
                    }
                    if (!nodeToMove.isLeftChildEmpty()) {
                        parentNodeToMove.setRightChild(nodeToMove.getLeftChild());
                    } else {
                        parentNodeToMove.removeRightChild();
                    }
                    nodeToMove.setLeftChild(nodeToRemove.getLeftChild());
                    nodeToMove.setRightChild(nodeToRemove.getRightChild());
                    if (nodeToRemove == root) {
                        root = nodeToMove;
                    } else {
                        if (nodeToRemove == parentNodeToRemove.getRightChild()) {
                            parentNodeToRemove.setRightChild(nodeToMove);
                        } else {
                            parentNodeToRemove.setLeftChild(nodeToMove);
                        }
                    }
                    nodeCount--;
                } else {
                    nodeToMove.setRightChild(nodeToRemove.getRightChild());
                    if (nodeToRemove == root) {
                        root = nodeToMove;
                    } else {
                        if (nodeToRemove == parentNodeToRemove.getRightChild()) {
                            parentNodeToRemove.setRightChild(nodeToMove);
                        } else {
                            parentNodeToRemove.setLeftChild(nodeToMove);
                        }
                    }
                    nodeCount--;
                }
            } else if (!nodeToRemove.isRightChildEmpty()) {
                nodeToMove = nodeToRemove.getRightChild();
                if (!nodeToMove.isLeftChildEmpty()) {
                    while (!nodeToMove.isLeftChildEmpty()) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.getLeftChild();
                    }
                    if (!nodeToMove.isRightChildEmpty()) {
                        parentNodeToMove.setLeftChild(nodeToMove.getRightChild());
                    } else {
                        parentNodeToMove.removeLeftChild();
                    }
                    nodeToMove.setRightChild(nodeToRemove.getRightChild());
                    nodeToMove.setLeftChild(nodeToRemove.getLeftChild());
                    if (nodeToRemove == root) {
                        root = nodeToMove;
                    } else {
                        if (nodeToRemove == parentNodeToRemove.getRightChild()) {
                            parentNodeToRemove.setRightChild(nodeToMove);
                        } else {
                            parentNodeToRemove.setLeftChild(nodeToMove);
                        }
                    }
                    nodeCount--;
                } else {
                    nodeToMove.setRightChild(nodeToRemove.getRightChild());
                    if (nodeToRemove == root) {
                        root = nodeToMove;
                    } else {
                        if (nodeToRemove == parentNodeToRemove.getRightChild()) {
                            parentNodeToRemove.setRightChild(nodeToMove);
                        } else {
                            parentNodeToRemove.setLeftChild(nodeToMove);
                        }
                    }
                    nodeCount--;
                }
            } else {
                if (nodeToRemove != root) {
                    if (parentNodeToRemove.getLeftChild() == nodeToRemove) {
                        parentNodeToRemove.removeLeftChild();
                    } else {
                        parentNodeToRemove.removeRightChild();
                    }
                    nodeCount--;
                } else {
                    throw new JustRootItemException();
                }
            }
        }
    }

    public List<Integer> getSortedTreeAsc() {
        Stack<Node> elementStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        Node currentNode = root;
        elementStack.push(currentNode);

        while (!elementStack.empty()) {
            if (!currentNode.isLeftChildEmpty()) {
                currentNode = currentNode.removeLeftChild();
                elementStack.push(currentNode);
            } else if (!currentNode.isRightChildEmpty()) {
                result.add(elementStack.peek().getValue());
                currentNode = currentNode.removeRightChild();
                elementStack.push(currentNode);
            } else {
                if (!result.contains(elementStack.peek().getValue())) {
                    result.add(elementStack.pop().getValue());
                } else {
                    elementStack.pop();
                }
                if (!elementStack.empty()) {
                    currentNode = elementStack.peek();
                }
            }
        }
        return result;
    }

    public List<Integer> getSortedTreeDesc() {
        Stack<Node> elementStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        Node currentNode = root;
        elementStack.push(currentNode);

        while (!elementStack.empty()) {
            if (!currentNode.isRightChildEmpty()) {
                currentNode = currentNode.removeRightChild();
                elementStack.push(currentNode);
            } else if (!currentNode.isLeftChildEmpty()) {
                result.add(elementStack.peek().getValue());
                currentNode = currentNode.removeLeftChild();
                elementStack.push(currentNode);
            } else {
                if (!result.contains(elementStack.peek().getValue())) {
                    result.add(elementStack.pop().getValue());
                } else {
                    elementStack.pop();
                }
                if (!elementStack.empty()) {
                    currentNode = elementStack.peek();
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Binary Sort";
    }
}
