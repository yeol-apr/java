package com.gonsi.dao.impl;

import com.gonsi.dao.BaseDao;
import com.gonsi.dao.SysUserDao;
import com.gonsi.pojo.SysUser;

import java.util.List;

public class Sysuserdaoimpl extends BaseDao implements SysUserDao {
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd from sys_user where username = ?";
//        String sql = "select * from sys_user ";
        List<SysUser>  sysUserList= baseQuery(SysUser.class,sql,username);
        return sysUserList!= null && sysUserList.size()>0? sysUserList.get(0): null ;
    }


    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";

        return baseAdd(sql,sysUser.getUsername(),sysUser.getUser_pwd());
    }

    public static void main(String[] args) {
        SysUserDao sysUserDao = new Sysuserdaoimpl();
        SysUser sysUser = new SysUser();
        System.out.println(sysUserDao.findByUsername("wangwuewd"));
    }
}
