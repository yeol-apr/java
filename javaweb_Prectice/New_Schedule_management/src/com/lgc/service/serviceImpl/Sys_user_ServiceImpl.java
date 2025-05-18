package com.lgc.service.serviceImpl;

import com.lgc.Dao.DaoImpl.Sys_UserDaoImpl;
import com.lgc.Dao.Sys_UserDa0;
import com.lgc.project.Sys_user;
import com.lgc.service.Sys_user_Service;

public class Sys_user_ServiceImpl implements Sys_user_Service {
    Sys_UserDa0 sys_user_dao = new Sys_UserDaoImpl();

    @Override
    public Sys_user selectByuser(String username) {
        return sys_user_dao.SelectSys_user(username);
    }

    @Override
    public int updateByPrimaryKeySelective(Sys_user sys_user_update) {

        return sys_user_dao.updateSys_user(sys_user_update);
    }
}
