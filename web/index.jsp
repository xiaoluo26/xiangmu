
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录错误</title>
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
      text-align: center;
    }

    .error-message {
      color: red;
      font-size: 18px;
      margin-bottom: 20px;
    }

    .button {
      background-color: #4CAF50;
      color: white;
      border: none;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<div class="container">
  <p class="error-message">账号或密码错误</p>
  <form action="Login.jsp">
    <button class="button" type="submit">返回</button>
  </form>
</div>
</body>
</html>
