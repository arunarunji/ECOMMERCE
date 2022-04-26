package com.model;

public abstract class User {


    private final String mailId;
    private final String password;
    public final String userType;

    public User(String mailId, String userPassword, String userType) {
        this.mailId = mailId;
        this.password = userPassword;
        this.userType = userType;
    }

    public String getUserMailID() {
        return mailId;
    }

    public String getUserPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}

