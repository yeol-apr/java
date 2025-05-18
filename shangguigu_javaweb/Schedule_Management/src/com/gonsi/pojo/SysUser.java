package com.gonsi.pojo;

import java.io.Serializable;
import java.util.Objects;

public class SysUser implements Serializable {
/*
*1:实体类名称和表格名应该一致
* 2：实体类属性名和表格列名应该一致
* 3：属性私有
* 4：具备get和set方法
* 5：具备无参构造器
* 6：实现序列化接口
* 7:重写类的hashcode和equals方法
* 8：toString
*
*
* 使用Lombok生成get set 登
* lombok使用
* 1：检查idea是否安装lombok
* 2:检查是否勾选了enoble amotation processer
* 3：在实体类上添加注解
*/
    private Integer uid;
    private String username;
    private String user_pwd;
//    必须要有无参构造器


    public SysUser() {
    }

    public SysUser(Integer uid, String username, String user_pwd) {
        this.uid = uid;
        this.username = username;
        this.user_pwd = user_pwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
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
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(uid, sysUser.uid) && Objects.equals(username, sysUser.username) && Objects.equals(user_pwd, sysUser.user_pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, user_pwd);
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}
