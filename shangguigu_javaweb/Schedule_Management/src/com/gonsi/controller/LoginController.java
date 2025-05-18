package com.gonsi.controller;

import com.gonsi.pojo.SysUser;
import com.gonsi.service.Sysuserservice;
import com.gonsi.service.impl.SysuerImpl;
import com.gonsi.util.MD5Util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        SysUser sysUser_request = new SysUser();
        sysUser_request.setUsername(request.getParameter("username"));
        sysUser_request.setUser_pwd(request.getParameter("password"));
        Sysuserservice sysuserservice = new SysuerImpl();
        SysUser sysuserservice_Login = sysuserservice.findByUsername(request.getParameter("username"));
        if (null == sysuserservice_Login){
            printWriter.write("未找到用户名,去<a href=\"registration.html\" target=\"_blank\">注册</a>");
        } else if (! sysuserservice_Login.getUser_pwd().equals(MD5Util.encrypt(sysUser_request.getUser_pwd()))) {
            printWriter.write("mimacuowu");
        }else {
            printWriter.write("登录成功");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }
}
