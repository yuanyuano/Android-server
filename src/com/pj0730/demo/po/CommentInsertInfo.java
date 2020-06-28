package com.pj0730.demo.po;

public class CommentInsertInfo {
    private int hostID;
    private int dynamicID;
    private String com_content;
    private String time;

    public CommentInsertInfo(int hostID, int dynamicID, String com_content, String time) {
        this.hostID = hostID;
        this.dynamicID = dynamicID;
        this.com_content = com_content;
        this.time = time;
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

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
