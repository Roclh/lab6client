package com.classes.serverSide.answers;

import java.io.Serializable;

public class FineAnswer extends com.classes.serverSide.answers.Answer implements Serializable {
    public FineAnswer(String value) {
        super(value);
    }

    public FineAnswer(com.classes.serverSide.answers.Answer answer) {
        super(answer);
    }

}
