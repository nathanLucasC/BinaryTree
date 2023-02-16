package com.sparta;

import java.util.logging.ConsoleHandler;

public class Starter {


    public static void start(){
        FileHandlerConfig.getFileHandler();
        CreateBinaryTree test = new CreateBinaryTree();
        test.addValue(6);
        test.addValue(4);
        test.addValue(8);
        test.addValue(3);
        test.addValue(5);
        test.addValue(7);
        test.addValue(9);

        try{
            test.getLeftChild(4);
            System.out.println(test.getLeftChild(4));
        }
        catch(ChildNotFoundException e){
            e.message();
        }
    }
}
