package com.klein.blue19.hous.dao.implement;

import com.klein.blue19.hous.dao.LoginDao;
import com.klein.blue19.hous.project.LoginPoro;
import com.klein.blue19.hous.util.MysqlUtil;

import java.sql.*;


public class LoginDaoImpl implements LoginDao {


    @Override
    public int AddTenantsData(LoginPoro tenants_a) {
        Connection connection = MysqlUtil.MysqlUtil_coon();
        PreparedStatement preparedStatement = null;
        int rows = 0;
        String sql = "insert into login(id,user,password)  values (default, ? ,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,tenants_a.getUser());
            preparedStatement.setObject(2,tenants_a.getPassword());
            rows = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public LoginPoro FindbyUsername(String username) {
        LoginPoro tenants_selcte = new LoginPoro();
        Connection connection = MysqlUtil.MysqlUtil_coon();
        ResultSet result = null;
        String sql = "select * from login where user = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <2 ; i++) {
                preparedStatement.setObject(i,username);
            }
            result = preparedStatement.executeQuery();
            ResultSetMetaData metaData =result.getMetaData();
            int n  = metaData.getColumnCount();
            if (result.next()){
                tenants_selcte.setUser("user");
                tenants_selcte.setPassword(result.getString("password"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return tenants_selcte;
    }



}
