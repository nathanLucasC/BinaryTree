package com.sparta;

import java.util.*;

public class CreateBinaryTree implements BinaryTree{

    Node root;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    int nodeCount = 0;
    private Node addRecursive(Node current, int value){
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeftChild(addRecursive(current.getLeftChild(), value));
        } else if (value > current.getValue()) {
            current.setRightChild( addRecursive(current.getRightChild(), value));
        } else {
            return current;
        }
        return current;
    }


    private boolean checkRecursive(Node current, int value){
        if(current == null){
            return false;
        }
        if(value == current.getValue()){
            return true;
        }
        if(value < current.getValue()){
            return checkRecursive(current.getLeftChild(),value);
        }
        return checkRecursive(current.getRightChild(),value);
    }
    private int checkLeftChild(Node current,int value){
        if(current == null){
            return root.getLeftChild().getValue();
        }if(current.isLeftChildEmpty()) {
            //error handling goes here
            return -1;
        }
        else if(value == current.getValue()){
            return current.getLeftChild().getValue();
        }
        if(value < current.getValue()){
            return checkLeftChild(current.getLeftChild(), value);
        }
        return checkLeftChild(current.getRightChild(), value);
    }
    private int checkRightChild(Node current,int value){
        if(current == null){
            return root.getRightChild().getValue();
        }
        if(current.isLeftChildEmpty()) {
            //error handling goes here
            return -1;
        }
        else if(value == current.getValue()){
            return current.getRightChild().getValue();
        }
        if(value < current.getValue()){
            return checkRightChild(current.getLeftChild(), value);
        }
        return checkRightChild(current.getRightChild(), value);
    }
    private int[] sortAsc(Node node){
        if(numbers.size() != getNumberOfNodes()) {
            numbers.clear();
            depthFirstSearch(node);
        }
        int[] array = new int[numbers.size()];

        for(int i=0; i<numbers.size();i++){
            array[i]=numbers.get(i);
        }
        Arrays.sort(array);
        return array;
    }
    private  int[] sortDesc(Node node){
        int[]array = sortAsc(node);
        int[]reverseArray=new int[array.length];
        int x=0;
        for(int i=array.length-1;i>-1;i--){
            reverseArray[x] = array[i];
            x++;
        }
        return reverseArray;
    }
    private void depthFirstSearch(Node node){
        if(node != null){
            depthFirstSearch(node.getLeftChild());
            numbers.add(node.getValue());
            depthFirstSearch(node.getRightChild());
        }
    }
    @Override
    public int getRootValue() {
        return root.getValue();
    }

    @Override
    public int getNumberOfNodes() {
        return nodeCount;
    }

    @Override
    public void addValue(int value) {
        BinaryLogger.createLog("INFO", "Element added to tree");
        root = addRecursive(root, value);
        nodeCount++;
    }

    @Override
    public void addValues(int[] values) {
        for(int i=0;i<values.length; i++){
            addValue(values[i]);
            BinaryLogger.createLog("INFO", "Element added to tree");
        }
    }

    @Override
    public boolean findValue(int value) {
        return checkRecursive(root,value);

    }

    @Override
    public int getLeftChild(int value) throws ChildNotFoundException{
        if(checkLeftChild(root,value) == -1){
            BinaryLogger.createLog("WARNING", "No left child found - Exception thrown");
            throw new ChildNotFoundException();
        }
        else {
            BinaryLogger.createLog("INFO", "Left child found when getLeftChild method runs");
            return checkLeftChild(root,value);
        }

    }

    @Override
    public int getRightChild(int value) throws ChildNotFoundException{
        if(checkRightChild(root,value) == -1){
            BinaryLogger.createLog("WARNING", "No right child found - Exception thrown");
            throw new ChildNotFoundException();
        }
        else {
            BinaryLogger.createLog("INFO", "Right child found when getRightChild method runs");
            return checkRightChild(root,value);
        }
    }

    @Override
    public int[] getSortedTreeAsc() {
        BinaryLogger.createLog("INFO", "Tree sorted in ascending order");
        return sortAsc(root);
    }

    @Override
    public int[] getSortedTreeDesc() {
        BinaryLogger.createLog("INFO", "Tree sorted in descending order");
        return sortDesc(root);
    }

}
