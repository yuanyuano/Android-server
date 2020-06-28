package com.pj0730.demo.po;

public class CommentInfo {
    private int hostID;
    private int dynamicID;
    private String hostAvatar;
    private String hostNick;
    private String createTime;
    private String com_textFiled;

    public CommentInfo(int hostID, int dynamicID, String hostAvatar, String hostNick, String createTime, String com_textFiled) {
        this.hostID = hostID;
        this.dynamicID = dynamicID;
        this.hostAvatar = hostAvatar;
        this.hostNick = hostNick;
        this.createTime = createTime;
        this.com_textFiled = com_textFiled;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public int getDynamicID() {
        return dynamicID;
    }

    public void setDynamicID(int dynamicID) {
        this.dynamicID = dynamicID;
    }

    public String getHostAvatar() {
        return hostAvatar;
    }

    public void setHostAvatar(String hostAvatar) {
        this.hostAvatar = hostAvatar;
    }

    public String getHostNick() {
        return hostNick;
    }

    public void setHostNick(String hostNick) {
        this.hostNick = hostNick;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCom_textFiled() {
        return com_textFiled;
    }

    public void setCom_textFiled(String com_textFiled) {
        this.com_textFiled = com_textFiled;
    }
}
