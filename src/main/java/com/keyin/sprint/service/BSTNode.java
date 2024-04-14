package com.keyin.sprint.service;

public class BSTNode {
    private int value;
    private BSTNode left;
    private BSTNode right;

    // No-argument constructor
    public BSTNode() {}

    // Constructor with arguments
    public BSTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Public getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}

