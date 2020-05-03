package com.exceptions;

public class NoSuchPersonException extends Exception{
    private String message = "Такого id не существует";

    @Override
    public String getMessage(){
        return message;
    }
}
