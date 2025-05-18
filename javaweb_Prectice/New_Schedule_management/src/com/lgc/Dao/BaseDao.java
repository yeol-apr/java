package com.lgc.Dao;

import com.lgc.Util.MySql_Util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class BaseDao {


    public <T>List selectByPrimaryKey(String sql, Object ... args){
        /**
         * 根据字符串sql语句，返回一个list集合
         */
        ArrayList List = new ArrayList<>();
        Connection connection = MySql_Util.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int ColumnCount = metaData.getColumnCount();
            while (resultSet.next()){
                Map<String,String> map = new HashMap<>();
                for (int i = 1; i <= ColumnCount ; i++) {
                    String Key = metaData.getColumnName(i);
                    String Value = resultSet.getString(Key);
                    map.put(Key,Value);
               }
                List.add(map);
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return List;
    }


    /**
     * 测试
     */
    public static void main(String[] args) {

    }
    /**
     * 查询数据库的基础方法
     */

    public <T>List Query(Class class_type , String sql ,Object ... args ){
        ArrayList List = new ArrayList();
        Connection connection = MySql_Util.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                Object obj = class_type.getDeclaredConstructor().newInstance();
            for (int i = 1; i <= columnCount ; i++) {
                String columnName = metaData.getColumnName(i);
                Object value = resultSet.getObject(columnName);
                if(value.getClass().equals(LocalDate.class)){
                    value = Timestamp.valueOf((LocalDateTime) value);
                }
                Field field = class_type.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(obj,value);
            }
            List.add((T)obj);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return List;
    }


    /**
     * 数据库的增删改方法
     */
    public int BaseUpdate(String sql , Object ... args){
        int rows = 0;
        Connection connection = MySql_Util.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            rows = preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            MySql_Util.closeConnection(connection);
        }


        return rows;
    }
}
