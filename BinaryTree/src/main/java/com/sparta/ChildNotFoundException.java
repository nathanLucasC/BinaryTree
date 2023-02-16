package com.sparta;

public class ChildNotFoundException extends Exception{
    public ChildNotFoundException(){
    }

    public void message(){
        String message = "Child class not found.";
        System.out.println(message);
    }


}
