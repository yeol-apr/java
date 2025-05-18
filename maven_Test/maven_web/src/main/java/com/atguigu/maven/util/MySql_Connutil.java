package com.atguigu.maven.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql_Connutil {

    public static Connection connection = null;
    public static final String url = "jdbc:mysql://121.40.186.182:3306/java_idea_text1?useUnicode=true&characterEncoding=gbk";
    public static final String user = "root";
    public static final String password = "12345678";

    public static Connection getConnections() {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("MySQL驱动加载完成");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try{
            connection = DriverManager.getConnection(url,user,password);
            //System.out.println("数据库链接成功");
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return connection;

    }

//    public static void main(String[] args) {
//        getConnections();
//    }

}

