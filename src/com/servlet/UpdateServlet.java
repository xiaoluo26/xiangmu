package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.BlogInfo;
import com.entity.User;

public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String info = request.getParameter("info");
        String tag = request.getParameter("tag");
        String dateString = request.getParameter("date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = new java.sql.Date(dateFormat.parse(dateString).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date", e);
        }

        BlogInfo bloginfo = new BlogInfo();
        bloginfo.setName(name);
        bloginfo.setInfo(info);
        bloginfo.setTag(tag);
        bloginfo.setDate(date);

        UserDao ud = new UserDaoImpl();

        if (ud.addinfo(bloginfo)) {
            request.setAttribute("addinfo", name);
            List<BlogInfo> blogInfoList = ud.getUserAll();
            request.setAttribute("userAll", blogInfoList);
            request.getRequestDispatcher("blog.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}