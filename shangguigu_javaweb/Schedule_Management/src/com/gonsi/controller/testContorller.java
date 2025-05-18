package com.gonsi.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "testContorller", value = "/testContorller/*")
public class testContorller extends BaseContorller {
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uername = req.getParameter("user");
        System.out.println(uername);
    }
}
