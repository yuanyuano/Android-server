package com.pj0730.demo.po;

public class test {
  private String username;
  private String usericon;

    public test(String username, String usericon) {
        this.username = username;
        this.usericon = usericon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsericon() {
        return usericon;
    }

    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }
}
