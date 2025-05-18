package com.klein.blue19.hous.contorller;

import com.klein.blue19.hous.project.LoginPoro;
import com.klein.blue19.hous.project.Tenants_a;
import com.klein.blue19.hous.service.LoginUser;
import com.klein.blue19.hous.service.implement.LoginUser_impl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet/*")
public class LoginServlet extends BaseContorller {

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Tenants_a tenants_web = new Tenants_a();
        tenants_web.setName(request.getParameter("name"));
        tenants_web.setPassword(request.getParameter("password"));
        PrintWriter printWriter = response.getWriter();
        LoginUser tenantId_service = new LoginUser_impl();
        LoginPoro tenants_service =  tenantId_service.FindTenant(tenants_web.getName());
        System.out.println(tenants_service.getUser());
        if(tenants_service.getUser()==null){
            System.out.println(tenants_service.getUser());
            printWriter.write("无用户名，跳转<a href=\"/registration.html\" target=\"_blank\">注册</a> ");
            //response.sendRedirect("/registration.html");
            return;

        }else if (tenants_service.getPassword().equals(tenants_web.getPassword())){
            printWriter.write("密码正确");
            request.getSession().setAttribute("tenantId_service",tenantId_service);
            response.sendRedirect("/first.html");
        }else {
            printWriter.write("密码不正确，重新输入");
        }


    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        LoginPoro loginPoro_web = new LoginPoro();
        System.out.println(req.getParameter("name"));
            loginPoro_web.setUser(req.getParameter("name"));
            loginPoro_web.setPassword(req.getParameter("password"));
        PrintWriter printWriter = resp.getWriter();
            LoginUser loginUser =  new LoginUser_impl();
            int rows = loginUser.addTenant(loginPoro_web);
            if (rows==0){
                printWriter.write("注册失败");
            }else {
                printWriter.write("注册成功，跳转<a href=\"/login.html\" target=\"_blank\">登录</a> ");
            }

    }
}
