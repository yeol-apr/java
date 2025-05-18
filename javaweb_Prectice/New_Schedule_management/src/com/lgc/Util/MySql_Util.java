package com.lgc.Util;

import java.sql.Connection;

public class MySql_Util {
    private static final String url = "jdbc:mysql://59.110.65.240:3306/javaweb?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "_Dxuzi.j3fkc";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = java.sql.DriverManager.getConnection(url, USERNAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();

        }
        return conn;
    }

    /**
     * 释放连接
     *
     */
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
