package com.gonsi.dao;

import com.gonsi.pojo.SysUser;

/**
 * 定义dao的接口。增删改查的方法实现
 * 作者：
 * 时间：
 *
 */
public interface SysUserDao {
    /*
    *该类用于表格的crud方法
    * dao层一般用于定义接口和实现类
    */
    /**
     *
     * @Param
     */
    int addSysUser(SysUser sysUser);
    SysUser findByUsername(String username);

}
