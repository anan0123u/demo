package com.example.demo.one.entity;

public class UserInfo {

    private int userId;

    private String userName;

    private String userPwd;

    public UserInfo() {
    }

    public UserInfo(int userId, String userName, String userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
