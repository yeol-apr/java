package com.lgc.test;

import com.lgc.Dao.BaseDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelcList {
    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        baseDao.selectByPrimaryKey("select * from sys_schedule ");
        List<Map<String, String>> result = baseDao.selectByPrimaryKey("select * from sys_schedule ");
        System.out.println(result);
    }
}
