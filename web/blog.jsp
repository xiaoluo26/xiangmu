<%@ page import="com.entity.BlogInfo" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人博客</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("img/preview-0000.jpg");
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
    </style>
</head>
<body>
<div class="container">
    <h1>欢迎来到博客！</h1>

    <a href="write.jsp">写博客</a>

    <div class="music">
        <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width="330" height="86" src="//music.163.com/outchain/player?type=2&id=862098473&auto=1&height=66"></iframe>
    </div>

    <form action="Searchall">
        <input type="submit" value="刷新">
    </form>

    <div class="neirong">
        <%
            List<BlogInfo> blogList = (List<BlogInfo>) request.getAttribute("userAll");
            if (blogList != null && !blogList.isEmpty()) {
                for (BlogInfo blog : blogList) {
        %>
        <div class="blog-post">
            <h2><%= blog.getName() %></h2>
            <p><%= blog.getInfo() %></p>
            <p>标签： <%= blog.getTag() %></p>
            <p>日期： <%= blog.getDate() %></p>
        </div>
        <%
            }
        } else {
        %>
        <p class="no-blog">暂无博客信息。</p>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
