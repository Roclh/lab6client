package com.exceptions;

public class NoSuchCommandException extends Exception{
    private String message = "Такой команды не существует";

    @Override
    public String getMessage(){
        return message;
    }
}
