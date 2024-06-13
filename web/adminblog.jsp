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

        .tags {
            text-align: center;
            margin-bottom: 20px;
        }

        .tag {
            display: inline-block;
            margin-right: 10px;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
        }

        .select-wrapper {
            text-align: center;
            margin-bottom: 20px;
        }

        .select-wrapper select {
            padding: 5px 10px;
            border-radius: 5px;
        }

        .btn {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }

        .btn:hover {
            background-color: #45a049; /* Darker Green */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>欢迎来到博客！</h1>

    <!-- 发布博客按钮 -->
    <button class="btn" onclick="window.location.href = 'write.jsp'">发布博客</button>

    <!-- 管理博客用户表单 -->
    <form action="SearchUser" method="post">
        <input class="btn" type="submit" value="管理博客用户">
    </form>

    <!-- 退出登录按钮 -->
    <button class="btn" onclick="window.location.href = 'Login.jsp'">退出登录</button>

    <!-- 音乐播放器 -->
    <div class="music">
        <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width="330" height="86"
                src="//music.163.com/outchain/player?type=2&id=862098473&auto=1&height=66"></iframe>
    </div>

    <!-- 标签选择框 -->
    <div class="select-wrapper">
        <select id="tagSelect" onchange="filterByTag(this.value)">
            <option value="all">全部标签</option>
            <%
                List<BlogInfo> blogList = (List<BlogInfo>) request.getAttribute("userAll");
                if (blogList != null && !blogList.isEmpty()) {
                    Set<String> allTags = new HashSet<>();
                    for (BlogInfo blog : blogList) {
                        allTags.add(blog.getTag());
                    }
                    for (String tag : allTags) {
            %>
            <option value="<%= tag %>"><%= tag %></option>
            <%
                    }
                }
            %>
        </select>
    </div>

    <div class="neirong">
        <%
            if (blogList != null && !blogList.isEmpty()) {
                for (BlogInfo blog : blogList) {
        %>
        <div class="blog-post" id="blog_<%= blog.getId() %>">
            <h2><%= blog.getName() %></h2>
            <p><%= blog.getInfo() %></p>
            <p>标签： <%= blog.getTag() %></p>
            <p>日期： <%= blog.getDate() %></p>
            <form action="DeleteServlet" method="post">
                <input type="hidden" name="id" value="<%=blog.getId()%>">
                <button class="btn" type="submit">删除博客</button>
            </form>
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

<!-- JavaScript 部分 -->
<script>
    // 点击标签时过滤博客条目
    function filterByTag(tag) {
        var blogPosts = document.querySelectorAll('.blog-post');
        for (var i = 0; i < blogPosts.length; i++) {
            var post = blogPosts[i];
            var postTag = post.querySelector('p:nth-child(3)').textContent.split('：')[1].trim(); // 获取博客条目的标签
            if (postTag === tag || tag === 'all') {
                post.style.display = 'block'; // 显示匹配标签的博客条目
            } else {
                post.style.display = 'none'; // 隐藏不匹配标签的博客条目
            }
        }
    }
</script>
</body>
</html>
