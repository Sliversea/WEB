<%--
  Created by IntelliJ IDEA.
  User: 章海银
  Date: 2020/10/15
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>

    <script type="text/javascript" src="js/changeCode.js"></script>
    <link rel="stylesheet" type="text/css" href="css/register.css">

</head>
<body>
<div class="wrap">
    <div class="container">
        <h1 style="color: white; margin: 0; text-align: center">登陆</h1>
        <form action="LoginServlet" method="post">
            <label><input type="text" placeholder="用户名"/></label>
            <label><input type="password" placeholder="密码" /></label>
            <label><input type="text" placeholder="验证码" name="verifycode" /></label>

            <img style="cursor: pointer" id="codePic" src="CheckCodeServlet" onclick="changeCode()" title="看不清楚换一张"/><br>
            <label class="oklogin"><input type="checkbox" id="check" name="tenDayLogin" value="ok">七天免登录</label>
            <input type="submit" value="登陆"/>
            <p class="change_link" style="text-align: center">
                <span class="text">没有账户？</span>
                <a href="index.jsp" class="to_login"> 立即注册 </a>
            </p>
        </form>
    </div>
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>

</body>
</html>
