<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录注册页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 300px;
            margin: 100px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }

        .title{
            text-align: center;
            color: #4CAF50;
        }

        input[type="text"],
        input[type="password"],
        input[type="submit"],
        input[type="reset"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="title">博客登录</div>
    <form action="DengluServlet" method="post">
        <label for="name">用户名：</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="pwd">密码：</label><br>
        <input type="password" id="pwd" name="pwd"><br>
        <input type="submit" value="登录" name="Denglu">
        <input type="reset" value="重置"><br>
    </form>
    <form action="Register.jsp">
        <input type="submit" value="新用户注册">
    </form>

</div>
</body>
</html>
