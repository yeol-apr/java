package com.gonsi.dao;
import com.gonsi.util.MySqlUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseDao {

        public  <T> List<T> baseQuery(Class class_Type,String sql,Object ... args){
            /**
             * @parpm  对象类型，sql，数据
             * @return 返回一个对象类型的LIsi
             */
            ArrayList List = new ArrayList<>();
            Connection connection = MySqlUtil.getConnection();
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement=connection.prepareStatement(sql);
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
                resultSet=preparedStatement.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int clonumber = metaData.getColumnCount();
                while (resultSet.next()){
                    Object obj = class_Type.getDeclaredConstructor().newInstance();
                    for (int i = 1; i <=clonumber ; i++) {
                           String cloName = metaData.getColumnLabel(i);
                           Object value = resultSet.getObject(cloName);
                        // 处理datetime类型字段和java.util.Data转换问题
                        if(value.getClass().equals(LocalDateTime.class)){
                            value= Timestamp.valueOf((LocalDateTime) value);
                        }
                           Field field = class_Type.getDeclaredField(cloName);
                           field.setAccessible(true);
                           field.set(obj,value);
                    }
                    List.add((T)obj);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                MySqlUtil.rentunConn(preparedStatement,resultSet,connection);
            }
            return  List;
        }



        public int baseAdd(String sql,Object
         ... args){
            int rows=0;
            Connection connection = MySqlUtil.getConnection();
            PreparedStatement preparedStatement=null;
            ResultSet resultSet = null;
            try {
                preparedStatement=connection.prepareStatement(sql);
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
                rows = preparedStatement.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {
                MySqlUtil.rentunConn(preparedStatement,resultSet,connection);
            }
            return rows;
        }





}
