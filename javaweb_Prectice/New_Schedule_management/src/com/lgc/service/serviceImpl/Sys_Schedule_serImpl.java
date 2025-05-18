package com.lgc.service.serviceImpl;

import com.lgc.Dao.DaoImpl.Sys_Sch_DaoImpl;
import com.lgc.Dao.Sys_Sch_Dao;
import com.lgc.project.Sys_schedule;
import com.lgc.service.Sys_Schedule_Service;

import java.util.List;

public class Sys_Schedule_serImpl implements Sys_Schedule_Service {
    private static Sys_Sch_Dao sys_sch_dao = new Sys_Sch_DaoImpl();
    @Override
    public int addSysSchedule_Sercice(Sys_schedule schedule) {

        return sys_sch_dao.addSys_schedule(schedule);
    }

    @Override
    public int updateSysSchedule_Service(Sys_schedule schedule) {
        return sys_sch_dao.updateSysSchedule(schedule);
    }

    @Override
    public int delecteSysSchedule_Service(int id) {
        return sys_sch_dao.delecteSysSchedule(id);
    }

    @Override
    public <T> List selectSysSchedule_Service(int page) {
        return sys_sch_dao.selectSysSchedule(page);
    }


    public <T> List selectSysSchedule_Service() {
        return sys_sch_dao.selectSysSchedule();
    }

}
