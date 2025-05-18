package com.klein.blue19.hous.project;

import java.io.Serializable;
import java.util.Objects;

public class LoginPoro implements Serializable {
    private int id;
    private String user;
    private String password;

    public LoginPoro() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginPoro LoginPoro = (LoginPoro) o;
        return id == LoginPoro.id && Objects.equals(user, LoginPoro.user) && Objects.equals(password, LoginPoro.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
