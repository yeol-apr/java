package com.klein.blue19.hous.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MysqlUtil {
    public static Connection MysqlUtil_coon(){
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/java_web?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String password = "020419";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Classdaoru");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            connection= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
