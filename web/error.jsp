<%--
  Created by IntelliJ IDEA.
  User: 章海银
  Date: 2020/9/18
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=7"/>
    <title>ERROR</title>
    <link rel="stylesheet" type="text/css" href="css/errorJump.css">
    <%--<script type="text/javascript" src="js/errorJump.js"></script>--%>

</head>
<body>
<div class="wrapper">
    <h3><span style="color: red">${Msg}</span></h3>
    <p class="tm">本页<span id="time" style="color: red">10</span>秒后自动返回登陆界面</p>
    <p class="btn">不能跳转,<a id="Btn" href="index.jsp" style="color: red;text-decoration: underline">请点击这</a></p>
</div>
<script>
    function sendStats(url) {
        var n = "log_" + (new Date()).getTime();
        var c = window[n] = new Image();
        c.onload = (c.onerror = function () {
            window[n] = null;
        });
        c.src = 'index.jsp' + url;
        c = null;
    }

    var time = document.getElementById('time');
    var btn = document.getElementById('Btn');

    function count() {
        if (+time.innerHTML > 0) {
            time.innerHTML = time.innerHTML - 1;
        } else {
            sendStats('gotoindex');
            location.href = btn.href;
        }
    }

    setInterval(count, 1000);

    btn.onclick = function () {
        sendStats('gotoindex');
    };
</script>
</body>
</html>
