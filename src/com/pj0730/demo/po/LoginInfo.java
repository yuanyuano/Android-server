package com.pj0730.demo.po;

public class LoginInfo {
    private int hostID;
    private String password;

    public LoginInfo(int hostID, String password) {
        this.hostID = hostID;
        this.password = password;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
