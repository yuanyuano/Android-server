package com.pj0730.demo.po;

public class PraiseInfo {
    private int dynamicID;
    private int hostID;

    public PraiseInfo(int dynamicID, int hostID) {
        this.dynamicID = dynamicID;
        this.hostID = hostID;
    }

    public int getDynamicID() {
        return dynamicID;
    }

    public void setDynamicID(int dynamicID) {
        this.dynamicID = dynamicID;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    @Override
    public String toString() {
        return "PraiseInfo{" +
                "dynamicID=" + dynamicID +
                ", hostID=" + hostID +
                '}';
    }
}
