<%@ page import="com.entity.BlogInfo" %>
<%@ page import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人博客</title>
</head>
<body>
<a>欢迎来到博客！</a>

<a href="write.jsp">写博客</a>

<div class="music">
    <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86 src="//music.163.com/outchain/player?type=2&id=862098473&auto=1&height=66"></iframe>
</div>

<form action="Searchall">
    <input type="submit" value="刷新">
</form>

<div>
    <%
        List<BlogInfo> blogList = (List<BlogInfo>) request.getAttribute("userAll");
        if (blogList != null && !blogList.isEmpty()) {
            for (BlogInfo blog : blogList) {
    %>
    <div>

        <h2><%= blog.getName() %></h2>
        <p><%= blog.getInfo() %></p>
        <p>标签： <%= blog.getTag() %></p>
        <p>日期： <%= blog.getDate() %></p>
    </div>
    <%
        }
    } else {
    %>
    <p>暂无博客信息。</p>
    <%
        }
    %>
</div>

</body>
</html>
