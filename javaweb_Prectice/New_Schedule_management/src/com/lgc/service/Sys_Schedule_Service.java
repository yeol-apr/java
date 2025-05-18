package com.lgc.service;

import com.lgc.project.Sys_schedule;

import java.util.List;

public interface Sys_Schedule_Service {

    /**
     * 添加日程
     * @param schedule
     * @return
     */
    int addSysSchedule_Sercice(Sys_schedule schedule);

    /**
     * 传入数据库类更改日程
     * @param schedule
     * @return
     */
    int updateSysSchedule_Service(Sys_schedule schedule);


    /**
     * 根据UID删除
     * @param id
     * @return
     */
    int delecteSysSchedule_Service(int id);


    /**
     * 可根据页码查询或全部返回语句
     * @param page
     * @return
     * @param <T>
     */

    <T> List selectSysSchedule_Service(int page);

    /**
     * 查询数据库总记录数
     * @return
     * @param <T>
     */
    <T> List selectSysSchedule_Service();



}
