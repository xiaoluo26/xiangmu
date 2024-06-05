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
</head>
<body>

<%
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date currentDate = new Date();
    String formattedDate = dateFormat.format(currentDate);
%>

<form action="UpdateServlet"  method="post"  style="padding-top:-700px;">
    标题：<input type="text" name="name" value=""><br><br>
    内容：  <input type="text" name="info" value=""><br><br>
    标签：<input type="text" name="tag" value=""><br><br>
    <input type="hidden" name="date" value="<%= formattedDate %>"><br>
    <input type="submit" value="上传" name="addinfo"><input type="reset" value="重置"><br>
</form>

</body>
</html>
