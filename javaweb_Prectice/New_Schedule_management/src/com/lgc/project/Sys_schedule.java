package com.lgc.project;

import java.io.Serializable;
import java.util.Objects;

public class Sys_schedule implements Serializable {
    private int uid;
    private String title;
    private int completed;

    private int sid;

    public Sys_schedule() {
    }

    @Override
    public String toString() {
        return "Sys_schedule{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", sid=" + sid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sys_schedule that)) return false;
        return getUid() == that.getUid() && getCompleted() == that.getCompleted() && getSid() == that.getSid() && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getTitle(), getCompleted(), getSid());
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
