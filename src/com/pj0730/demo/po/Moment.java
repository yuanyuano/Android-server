package com.pj0730.demo.po;

public class Moment {
    private String Time;
    private String HostID;
    private String mom_content;

    public Moment(String time, String hostID, String mom_content) {
        Time = time;
        HostID = hostID;
        this.mom_content = mom_content;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getHostID() {
        return HostID;
    }

    public void setHostID(String hostID) {
        HostID = hostID;
    }

    public String getMom_content() {
        return mom_content;
    }

    public void setMom_content(String mom_content) {
        this.mom_content = mom_content;
    }
}
