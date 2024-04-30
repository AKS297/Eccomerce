package com.app.ecomerce.api.model;

public class LogInBody {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = password;
    }
}
