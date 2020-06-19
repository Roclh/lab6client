package com.classes.serverSide.answers;

import java.io.Serializable;

public class Request implements Serializable {
    private String userName;
    private String command;
    private String arg1;
    private String arg2;

    public Request(String userName, String command, String arg1, String arg2) {
        this.userName = userName;
        this.command = command;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public String getUserName(){return userName;}

    public String getCommand() {
        return command;
    }

    public String getArg1() {
        return arg1;
    }

    public String getArg2(){
        return arg2;
    }
}
