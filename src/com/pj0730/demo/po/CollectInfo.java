package com.pj0730.demo.po;

public class CollectInfo {
    private int dynamicID;
    private int hostID;

    public CollectInfo(int dynamicID, int hostID) {
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
}
