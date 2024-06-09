<%--
  Created by IntelliJ IDEA.
  User: StarryWind
  Date: 2024/6/5
  Time: 下午2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>编写博客</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }

        input[type="text"],
        input[type="submit"],
        input[type="reset"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        textarea {
            width: calc(100% - 20px);
            height: 200px;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            resize: vertical;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            margin-right: 10px;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate); %>

    <form action="UpdateServlet" method="post">
        <label for="title">标题：</label><br>
        <input type="text" id="title" name="name" value=""><br>
        <label for="content">内容：</label><br>
        <textarea id="content" name="info" ></textarea><br>
        <label for="tags">标签：</label><br>
        <input type="text" id="tags" name="tag" value=""><br>
        <input type="hidden" name="date" value="<%= formattedDate %>"><br>
        <input type="submit" value="上传" name="addinfo">
        <input type="reset" value="重置">
    </form>
    <form action="Searchall">
        <input type="submit" value="返回博客">
    </form>
</div>
</body>
</html>
