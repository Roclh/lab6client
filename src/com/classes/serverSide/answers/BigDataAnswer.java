package com.classes.serverSide.answers;


import com.classes.Listener;

import java.io.Serializable;
import java.util.logging.Logger;

public class BigDataAnswer extends com.classes.serverSide.answers.Answer implements Serializable {
    private static final Logger logger = Logger.getLogger(Listener.class.getName());
    public BigDataAnswer() { super("BigData"); }

    public void printAnswer() {
        System.err.println(this.getValue());
    }
}