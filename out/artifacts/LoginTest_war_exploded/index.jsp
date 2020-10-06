<%--
  Created by IntelliJ IDEA.
  User: 章海银
  Date: 2020/9/18
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>登陆界面</title>

    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/jquery-1.3.1.js" type="text/javascript"></script>
    <script src="js/jquery.validate.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/vector.js"></script>
    <script type="text/javascript" src="js/changeCode.js"></script>
    <script type="text/javascript" src="js/backGroundImage.js"> </script>
    
</head>
<body>
<form action="LoginServlet" method="post">
    <div id="container">
        <div id="output">
            <div class="containerT">
                <h1>用户登录</h1>
                <input class="input" type="text" placeholder="用户名" id="entry_name" name="username">
                <input class="input" type="password" placeholder="密码" id="entry_password" name="password">
                <input class="input" type="text" placeholder="验证码" name="verifycode" id="entry_code">
                <img style="cursor: pointer" id="codePic" src="CheckCodeServlet" onclick="changeCode()" title="看不清楚换一张"/><br>
                <%--<span style="color: red;margin-bottom: 10px">${Msg}</span><br>--%>
                <label><input type="checkbox" id="check" name="tenDayLogin" value="ok">七天免登录</label>
                <input class="input" name="Submit" type="submit" class="button" id="Submit" value="登陆" style="cursor: pointer;">
            </div>
        </div>
    </div>
</form>




</body>
</html>
