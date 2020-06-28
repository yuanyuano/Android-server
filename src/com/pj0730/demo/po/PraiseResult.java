package com.pj0730.demo.po;

public class PraiseResult {
    private int dynamicID;
    private int haspriased;
    private int isprased;

    public PraiseResult(int dynamicID, int haspriased, int isprased) {
        this.dynamicID = dynamicID;
        this.haspriased = haspriased;
        this.isprased = isprased;
    }

    public int getDynamicID() {
        return dynamicID;
    }

    public void setDynamicID(int dynamicID) {
        this.dynamicID = dynamicID;
    }

    public int getHaspriased() {
        return haspriased;
    }

    public void setHaspriased(int haspriased) {
        this.haspriased = haspriased;
    }

    public int getIsprased() {
        return isprased;
    }

    public void setIsprased(int isprased) {
        this.isprased = isprased;
    }
}
