package com.lgc.Dao.DaoImpl;

import com.lgc.Dao.BaseDao;
import com.lgc.Dao.Sys_UserDa0;
import com.lgc.project.Sys_user;

import java.util.List;

public class Sys_UserDaoImpl  extends BaseDao implements Sys_UserDa0 {
    @Override
    public Sys_user SelectSys_user(String username) {
        String sql ="select uid,username,user_pwd  from sys_user where username = ?";
        List<Sys_user> sysUserList = Query(Sys_user.class, sql, username);
        return sysUserList!= null && sysUserList.size()>0? sysUserList.get(0): null ;
    }

    @Override
    public int updateSys_user(Sys_user sys_user_add) {
        String sql ="insert into sys_user(username,user_pwd) values(?,?)";

        return BaseUpdate(sql,sys_user_add.getUsername(),sys_user_add.getUser_pwd());
    }
}
