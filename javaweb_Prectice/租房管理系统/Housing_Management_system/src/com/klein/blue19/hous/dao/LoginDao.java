package com.klein.blue19.hous.dao;

import com.klein.blue19.hous.project.LoginPoro;

/**
 * 对于tenants表的操作
 */
public interface LoginDao {
    /**
     * 对数据增，删，改
     * @return int数据，0则失败，大于0则成功
     * @param  tenants_a 注册用户的全部信息
     */
    int AddTenantsData(LoginPoro tenants_a);
    /**
     * @return 通过user找到的tenants对象
     * @param username 用户名
     */
    LoginPoro FindbyUsername(String username);

}
