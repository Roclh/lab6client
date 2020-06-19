package com.classes;

public class Connection implements Comparable<Connection>{
    public String userName;
    public String password;

    public Connection(String userName, String password){
        this.userName = userName;
        this.password = password;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int compareTo(Connection o) {
        return 0;
    }
}
