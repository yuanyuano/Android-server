package com.pj0730.demo.po;

public class HostInsertInfo {
    private String hostNick;
    private String hostAvatar;
    private String password;

    public HostInsertInfo(String hostNick, String hostAvatar, String password) {
        this.hostNick = hostNick;
        this.hostAvatar = hostAvatar;
        this.password = password;
    }

    public String getHostNick() {
        return hostNick;
    }

    public void setHostNick(String hostNick) {
        this.hostNick = hostNick;
    }

    public String getHostAvatar() {
        return hostAvatar;
    }

    public void setHostAvatar(String hostAvatar) {
        this.hostAvatar = hostAvatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
