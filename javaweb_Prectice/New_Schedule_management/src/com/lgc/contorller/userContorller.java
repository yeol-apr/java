package com.lgc.contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgc.Util.MD5Util;
import com.lgc.Util.WebUtil;
import com.lgc.common.Result;
import com.lgc.common.ResultCodeEnum;
import com.lgc.project.Sys_user;
import com.lgc.service.Sys_user_Service;
import com.lgc.service.serviceImpl.Sys_user_ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "user" ,urlPatterns = "/user/*")
public class userContorller extends BaseContorller{

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * 登录方法
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应
        resp.setContentType("text/html;charset=utf-8");
        //获得用户名
        Sys_user sys_user_req = new Sys_user();
        sys_user_req.setUsername(req.getParameter("username"));
        sys_user_req.setUser_pwd(req.getParameter("password"));

        //数据库查询判断是否存在以及密码是否正确
        Sys_user_Service finde_sys_user = new Sys_user_ServiceImpl();

//        System.out.println("sys_user_req"+sys_user_req.getUser_pwd());
//        System.out.println("finde_sys_user"+
//                finde_sys_user.selectByuser(
//                        sys_user_req.getUsername()).getUser_pwd());
        if(null == finde_sys_user.selectByuser(sys_user_req.getUsername())){
            Result result = Result.build(null, ResultCodeEnum.USERNAEM_ERROR);
            WebUtil.writeJson(resp,result);
            return;
        }
        if(!finde_sys_user.selectByuser(sys_user_req.getUsername()).getUser_pwd()
                .equals(
                        MD5Util.encrypt(sys_user_req.getUser_pwd()))){
            Result result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            WebUtil.writeJson(resp,result);
        }else {
            resp.sendRedirect("/New_Schedule_management_war/Home_page.html");
        }


    }



    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用户注册
        Sys_user sys_user_register = new Sys_user();
        sys_user_register.setUsername(req.getParameter("username"));
        System.out.println("sys_user_register"+req.getParameter("password"));
        //密码加密
        sys_user_register.setUser_pwd(MD5Util.encrypt(req.getParameter("password")));
        Sys_user_Service sys_user_service = new Sys_user_ServiceImpl();
        int result= sys_user_service.updateByPrimaryKeySelective(sys_user_register);
        if(result>0){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>等待跳转...</title>");
                out.println("<script>");
                out.println("window.onload = function() {");
                out.println("    setTimeout(function() {");

                out.println("        window.location.href = '/login.html';"); // targetUrl 是你要重定向到的URL
                out.println("    }, 5000);"); // 延迟时间，单位是毫秒
                out.println("};");
                out.println("</script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>页面将在几秒后自动跳转...</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }else{
            resp.sendRedirect("registerFill.html");
        }


    }
}
