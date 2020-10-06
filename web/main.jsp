<%--
  Created by IntelliJ IDEA.
  User: 章海银
  Date: 2020/9/24
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登陆成功</title>
    <link rel="stylesheet" type="text/css" href="css/LoginSuccess.css">

</head>
<body>

    <div>
        <div class="user">
            ${CurrentUser.name}欢迎您！！！
            <a href="LogoutServlet" target="_parent">【安全退出】</a>
        </div>
        <ul>
            <li><a href="main.jsp">Home</a></li>
            <li><a href="main.jsp">News</a></li>
            <li><a href="FileDownServlet">Download</a></li>
            <li><a href="main.jsp">About</a></li>
        </ul>
    </div>

</body>

</html>
