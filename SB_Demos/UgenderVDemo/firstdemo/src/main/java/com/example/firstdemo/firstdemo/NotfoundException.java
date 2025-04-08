package com.example.firstdemo.firstdemo;

public class NotfoundException extends RuntimeException{

    public NotfoundException(int id){
        super("Details is not found for this:"+id);
    }
}
