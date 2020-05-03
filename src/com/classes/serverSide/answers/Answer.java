package com.classes.serverSide.answers;


import com.classes.Listener;

import java.io.Serializable;
import java.util.logging.Logger;

public abstract class Answer implements Serializable {
    private static final Logger logger = Logger.getLogger(Listener.class.getName());
    private String value;
    private int valueLength;

    public Answer(String value){
        this.value = value;
        this.valueLength = value.getBytes().length;
    }

    public Answer(Answer answer){
        this.value = answer.value;
        this.valueLength = answer.valueLength;
    }

    public void logAnswer(){
        logger.info(value);
    }

    public void setValue(String value){
        this.value = value;
        this.valueLength = value.getBytes().length;
    }

    public String getValue(){
        return this.value;
    }

    public int getValueLength(){
        return  this.valueLength;
    }

}
