package com.klein.blue19.hous.contorller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/Test/*")
public class test extends BaseContorller{

    protected void Test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletRequest request =(HttpServletRequest) req;
        HttpServletResponse response =(HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object  sysUser= session.getAttribute("tenantId_service");
        boolean isNew = session.isNew();
        System.out.println(isNew);
        // 向session对象中存入数据
        if(null != sysUser){
            // session中如果存在登录的用户 代表用户登录过,则放行
            System.out.println(sysUser.toString());

        }else{
            //用户未登录,重定向到登录页
            System.out.println("weidenglu");
        }
    }
    protected void testb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的参数
        String username = req.getParameter("username");
        // 获取session对象
        HttpSession session = req.getSession();
        // 获取Session的ID
        String jSessionId = session.getId();
        System.out.println(jSessionId);
        // 判断session是不是新创建的session
        boolean isNew = session.isNew();
        System.out.println(isNew);
        // 向session对象中存入数据
        session.setAttribute("username",username);

    }
}
