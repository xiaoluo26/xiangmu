package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.BlogInfo;
import com.entity.User;

public class Searchall extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao ud = new UserDaoImpl();
        //List<User> userAll = ud.getUserAll();
        List<BlogInfo> blogInfoList = ud.getUserAll(); // 注意变量名修改为blogInfoList
        request.setAttribute("userAll", blogInfoList); // 将blogInfoList存入request中
        request.getRequestDispatcher("/blog.jsp").forward(request, response);
    }
}