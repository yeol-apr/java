package com.atguigu.maven.dao;

import com.atguigu.maven.util.MySql_Connutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    public static void writerLogin(String ip,String username  ,String datatime ){
        Connection connection = MySql_Connutil.getConnections();
        try{
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO text(ip,username,datatime) VALUES('"+ip+"','"+username+"','"+datatime+"')";
            //System.out.println(sql);
            int i  = statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        writerLogin("123321","wangzi","12-23-34");
//    }
}
