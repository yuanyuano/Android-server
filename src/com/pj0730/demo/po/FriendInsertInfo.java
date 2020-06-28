package com.pj0730.demo.po;

public class FriendInsertInfo {
    private int hostID;
    private int friendID;

    public FriendInsertInfo(int hostID, int friendID) {
        this.hostID = hostID;
        this.friendID = friendID;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public int getFriendID() {
        return friendID;
    }

    public void setFriendID(int friendID) {
        this.friendID = friendID;
    }
}
