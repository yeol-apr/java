package com.atguigu.maven.controller;

import com.atguigu.maven.dao.LoginDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "login_controller_Servlet", value = "/login_controller_Servlet")
public class login_controller_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String Method = request.getMethod();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter print = response.getWriter();
        print.println("到达主页面" );
        String usernamme = request.getParameter("username");
        String password  = request.getParameter("password");
        String ip = request.getRemoteAddr();
        //System.out.println("用户："+usernamme+"通过ip："+ip+"访问");
       // 一、获取当前系统时间和日期并格式化输出:
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateTime = df.format(date); // Formats a Date into a date/time string.
        //System.out.println(dateTime);  // 2019-07-03 10:14:14
        LoginDao.writerLogin(ip,usernamme,dateTime);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
