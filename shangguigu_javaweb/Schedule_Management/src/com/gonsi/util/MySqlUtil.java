package com.gonsi.util;

import java.sql.*;

public class MySqlUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/java_web";
    private static final String USER = "root";
    private static final String PASSWORD = "020419";

    public static Connection connection = null;

    public static Connection getConnection(){
        /**
         * @return:返回mysql连接
         */
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("com.mysql.jdbc.Driver失败");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void rentunConn(PreparedStatement preparedStatement, ResultSet resultSet ,Connection connection){
        /**
         * 归还连接
         * @param connection：连接 resultSet结果及 preparedStatement连接
         */

            try {
                if(null!= preparedStatement) {
                    preparedStatement.close();
                }
                if (null!=resultSet){
                    resultSet.close();
                }
                if(null!=connection){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }


}



