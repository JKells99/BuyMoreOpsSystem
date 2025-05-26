package com.buymore.user;

public class LoginCreds {
    private String userName;
    private String password;

    public LoginCreds(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginCreds() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
