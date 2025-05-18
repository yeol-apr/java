package com.klein.blue19.hous.service.implement;

import com.klein.blue19.hous.dao.LoginDao;
import com.klein.blue19.hous.dao.implement.LoginDaoImpl;
import com.klein.blue19.hous.project.LoginPoro;
import com.klein.blue19.hous.service.LoginUser;

public class LoginUser_impl implements LoginUser {
    protected  LoginDao tenantsDao =new LoginDaoImpl();
    @Override
    public LoginPoro FindTenant(String Tenant_a) {

        return tenantsDao.FindbyUsername(Tenant_a);
    }

    @Override
    public int addTenant(LoginPoro uerlogin) {
        return tenantsDao.AddTenantsData(uerlogin);
    }



}
