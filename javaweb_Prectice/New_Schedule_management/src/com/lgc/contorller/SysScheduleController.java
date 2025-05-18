package com.lgc.contorller;

import com.lgc.Util.WebUtil;
import com.lgc.common.Result;
import com.lgc.common.ResultCodeEnum;
import com.lgc.common.Str_to_Int;
import com.lgc.project.Sys_schedule;
import com.lgc.service.Sys_Schedule_Service;
import com.lgc.service.serviceImpl.Sys_Schedule_serImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/SysSchedule/*")
public class SysScheduleController extends BaseContorller{
    private Sys_schedule sys_schedule = new Sys_schedule();
    private  Sys_Schedule_Service sys_schedule_service = new Sys_Schedule_serImpl();

    protected void addSysSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //添加日志记录
        System.out.println("uid:"+req.getParameter("uid"));
        System.out.println("completed:"+req.getParameter("completed"));
        System.out.println("title:"+req.getParameter("title"));
        int uid = Str_to_Int.Str_to_Int(req.getParameter("uid"));
        int completed = Str_to_Int.Str_to_Int(req.getParameter("completed"));

        sys_schedule.setUid(uid);
        sys_schedule.setTitle(req.getParameter("title"));
        sys_schedule.setCompleted(completed);

        int re = sys_schedule_service.addSysSchedule_Sercice(sys_schedule);
        if (re>=1){
            Result result = Result.build(null, ResultCodeEnum.SUCCESS);
            WebUtil.writeJson(resp, result);
        }else {
            Result result = Result.build(null, ResultCodeEnum.ERROR);
            WebUtil.writeJson(resp, result);
        }
    }


    /**
     * 修改数据，传入uid,title,completed
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void updateSysSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Str_to_Int.Str_to_Int(req.getParameter("uid"));
        int sid = Str_to_Int.Str_to_Int(req.getParameter("sid"));
        int completed = Str_to_Int.Str_to_Int(req.getParameter("completed"));

        String title = req.getParameter("title");
        sys_schedule.setSid(sid);
        sys_schedule.setUid(uid);
        sys_schedule.setTitle(title);
        sys_schedule.setCompleted(completed);
        Sys_Schedule_Service sys_schedule_service = new Sys_Schedule_serImpl();
        int res =  sys_schedule_service.updateSysSchedule_Service(sys_schedule);
        if (res>=1){
            Result result = Result.build(null, ResultCodeEnum.SUCCESS);
            WebUtil.writeJson(resp, result);
        }else {
            Result result = Result.build(null, ResultCodeEnum.ERROR);
            WebUtil.writeJson(resp, result);
        }

    }
    /**
     * 删除数据,根据数据库sid
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteSysSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Str_to_Int.Str_to_Int(req.getParameter("uid"));
        int res = sys_schedule_service.delecteSysSchedule_Service(sid);
        if (res>=1){
            Result result = Result.build(null, ResultCodeEnum.SUCCESS);
            WebUtil.writeJson(resp, result);
        }else {
            Result result = Result.build(null, ResultCodeEnum.ERROR);
            WebUtil.writeJson(resp, result);
        }

    }


    /**
     * 查找数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void selectSysSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Str_to_Int.Str_to_Int(req.getParameter("page"));

        List list =  sys_schedule_service.selectSysSchedule_Service(uid);

        Result result = Result.build(list, ResultCodeEnum.SUCCESS);
        WebUtil.writeJson(resp,result);
    }

    protected void selectSysSchedule_DB(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list =  sys_schedule_service.selectSysSchedule_Service();
        Result result = Result.build(list, ResultCodeEnum.SUCCESS);
        WebUtil.writeJson(resp,result);
    }

}
