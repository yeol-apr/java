package com.lgc.Dao;

import com.lgc.project.Sys_schedule;

import java.util.List;

public interface Sys_Sch_Dao {

    /**
     * 添加日程
     * @param sys_schedule
     * @return
     */
    int addSys_schedule(Sys_schedule sys_schedule);


    /**
     * 传入数据库类更改日程
     * @param schedule
     * @return
     */
    int updateSysSchedule(Sys_schedule schedule);


    /**
     * 根据UID删除
     * @param id
     * @return
     */
    int delecteSysSchedule(int id);



    /**
     * 可根据页码查询或全部返回语句
     * @param page
     * @return
     * @param <T>
     */
    <T> List<T> selectSysSchedule(int page);

    /**
     * 查询数据库总记录数
     * @return
     * @param <T>
     */
    <T> List<T> selectSysSchedule();




}
