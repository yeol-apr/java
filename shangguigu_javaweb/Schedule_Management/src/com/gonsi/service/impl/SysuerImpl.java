package com.gonsi.service.impl;

import com.gonsi.dao.SysUserDao;
import com.gonsi.dao.impl.Sysuserdaoimpl;
import com.gonsi.pojo.SysUser;
import com.gonsi.service.Sysuserservice;
import com.gonsi.util.MD5Util;

public class SysuerImpl implements Sysuserservice {
    private  SysUserDao sysUserDao = new Sysuserdaoimpl();
    @Override
    public int regist(SysUser sysUser) {
        sysUser.setUser_pwd(MD5Util.encrypt(sysUser.getUser_pwd()));
        return sysUserDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {


        return sysUserDao.findByUsername(username);
    }
}
