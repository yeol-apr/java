package com.lgc.Dao.DaoImpl;

import com.lgc.Dao.BaseDao;
import com.lgc.Dao.Sys_Sch_Dao;
import com.lgc.Util.MySql_Util;
import com.lgc.project.Sys_schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Sys_Sch_DaoImpl extends BaseDao implements Sys_Sch_Dao {
    @Override
    public int addSys_schedule(Sys_schedule sys_schedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";

        return BaseUpdate(sql,sys_schedule.getUid(),sys_schedule.getTitle(),sys_schedule.getCompleted());
    }




    @Override
    public int updateSysSchedule(Sys_schedule schedule) {
        String sql = "update sys_schedule set title = ?,completed = ? where sid = ?";
        return BaseUpdate(sql,schedule.getTitle(),schedule.getCompleted(),schedule.getSid());
    }



    @Override
    public int delecteSysSchedule(int id) {
        String sql = "delete from sys_schedule where sid = ?";
        return BaseUpdate(sql,id);
    }



    @Override
    public <T>List selectSysSchedule(int id) {
        String sql = "SELECT * FROM `sys_schedule`  LIMIT 10 OFFSET ?";
        if (id == 0) {
            return selectByPrimaryKey(sql, id);
        }else {
            id = id - 1;
            id = id * 10;
            return selectByPrimaryKey(sql, id);
        }
    }


    public <T>List selectSysSchedule() {
        String sql = "select count(*) from sys_schedule";

        return selectByPrimaryKey(sql);

    }




}
