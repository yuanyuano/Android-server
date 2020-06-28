package com.pj0730.demo.po;

public class MyComment {
    private String avatar;
    private String name;
    private String comment;
    private String time;
    private String pic;

    public MyComment(String avatar, String name, String comment, String time, String pic) {
        this.avatar = avatar;
        this.name = name;
        this.comment = comment;
        this.time = time;
        this.pic = pic;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
