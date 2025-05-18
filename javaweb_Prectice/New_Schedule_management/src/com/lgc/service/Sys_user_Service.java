package com.lgc.service;

import com.lgc.project.Sys_user;

public interface Sys_user_Service {
    /**
     * @param username 按照用户名查找，返回Sys_user对象
     * @return Sys_user
     */
     Sys_user selectByuser(String username);


    /**
     *
     * @param sys_user_update  将Sys_user对象更新到数据库
     * @return int 大于0则更新成功
     */

    int updateByPrimaryKeySelective(Sys_user sys_user_update);

}
