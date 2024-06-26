package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.BlogInfo;

public class DengluAdminServlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name"); //得到jsp页面传过来的参数
        String pwd = request.getParameter("pwd");

        UserDao ud = new UserDaoImpl();

        if(ud.adminlogin(name, pwd)){

            List<BlogInfo> blogInfoList = ud.getBloginfoAll();
            request.setAttribute("userAll", blogInfoList);
            request.getRequestDispatcher("/adminblog.jsp").forward(request, response);//转发到成功页面
        }else{
            response.sendRedirect("index.jsp"); //重定向到首页
        }
    }

}