<%@ page import="com.entity.User" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人博客</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("img/02.png");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .blog-post {
            margin-bottom: 30px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        .blog-post h2 {
            margin-top: 0;
        }

        .blog-post p {
            margin-bottom: 10px;
            line-height: 1.5;
        }

        .music {
            margin-top: 20px;
            text-align: center;
        }

        .neirong {
            margin-top: 20px;
        }

        .no-blog {
            text-align: center;
        }

        /* 新增按钮样式 */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        /* 修改表单按钮的样式 */
        .btn-form {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>博客管理系统！</h1>

    <div class="neirong">
        <%
            List<User> userList = (List<User>) request.getAttribute("userAll");
            if (userList != null && !userList.isEmpty()) {
                for (User user : userList) {
        %>
        <div class="blog-post">
            <h2>账号:<%= user.getName() %></h2>
            <p>密码:<%= user.getPwd() %></p>
            <form action="DeleteUserServlet" method="post">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <!-- 修改按钮样式 -->
                <button class="btn-form" type="submit">删除用户</button>
            </form>
        </div>
        <%
            }
        } else {
        %>
        <p class="no-blog">暂无用户信息。</p>
        <%
            }
        %>
        <div>
            <form action="Searchall">
                <!-- 修改按钮样式 -->
                <input class="btn" type="submit" value="返回博客">
            </form>
        </div>
    </div>
</div>
</body>
</html>
