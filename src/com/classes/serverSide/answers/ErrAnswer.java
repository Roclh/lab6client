package com.classes.serverSide.answers;


import com.classes.Listener;

import java.io.Serializable;
import java.util.logging.Logger;

public class ErrAnswer extends com.classes.serverSide.answers.Answer implements Serializable {
    private static final Logger logger = Logger.getLogger(Listener.class.getName());
    public ErrAnswer(String answer) {
        super(answer);
    }

    @Override
    public void logAnswer() {
        logger.warning(this.getValue());
    }
}
