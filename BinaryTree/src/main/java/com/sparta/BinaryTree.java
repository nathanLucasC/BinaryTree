package com.sparta;

public interface BinaryTree {

    int getRootValue();

    int getNumberOfNodes();

    void addValue(int value);

    void addValues(int[] values);

    boolean findValue(int value);

    int getLeftChild(int value)throws ChildNotFoundException;

    int getRightChild(int value)throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
