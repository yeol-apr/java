package com.lgc.project;

import java.io.Serializable;
import java.util.Objects;

public class Sys_user implements Serializable {
    /**
     * 用户表实体类
     */

    private static final long serialVersionUID = 1L;

    private int uid;
    private String username;
    private String user_pwd;

    public Sys_user() {
    }

    public Sys_user(int uid, String username, String user_pwd) {
        this.uid = uid;
        this.username = username;
        this.user_pwd = user_pwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sys_user sysUser)) return false;
        return getUid() == sysUser.getUid() && Objects.equals(getUsername(), sysUser.getUsername()) && Objects.equals(getUser_pwd(), sysUser.getUser_pwd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getUsername(), getUser_pwd());
    }

    @Override
    public String toString() {
        return "Sys_user{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}
