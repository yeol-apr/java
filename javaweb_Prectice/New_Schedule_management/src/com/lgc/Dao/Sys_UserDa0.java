package com.lgc.Dao;

import com.lgc.project.Sys_user;

public interface Sys_UserDa0 {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    Sys_user SelectSys_user(String username);

    int updateSys_user(Sys_user sys_user_add);
}
