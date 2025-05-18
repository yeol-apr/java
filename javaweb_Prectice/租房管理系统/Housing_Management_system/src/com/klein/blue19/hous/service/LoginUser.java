package com.klein.blue19.hous.service;


import com.klein.blue19.hous.project.LoginPoro;

/**
 * 处理用户登录业务
 *
 */

public interface LoginUser {
    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return Tenants 如果找到了返回SysUser对象,找不到返回null
     */
    LoginPoro FindTenant(String username);

    int addTenant(LoginPoro tenants_a);
}
