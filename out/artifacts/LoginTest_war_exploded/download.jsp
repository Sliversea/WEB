<%--
  Created by IntelliJ IDEA.
  User: 章海银
  Date: 2020/9/27
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>下载页面</title>

    <link rel="stylesheet" type="text/css" href="css/download.css">
</head>


<body>
<div>
    <div class="user">
        ${CurrentUser.name}欢迎您！！！
        <a href="LogoutServlet" target="_parent" onClick="logout()">【安全退出】</a>
    </div>

</div>
<div style="margin: 0 auto">
    <h2>资源下载</h2>
</div>
<div class="container">
    <c:forEach var="file" items="${sessionScope.filelist}">
        <ul>
            <li>
                <p class="name">${file.id}、${file.name}</p>
                <div class="pic">
                    <div class="img_div">
                    <img class="img_area" src="${file.images}">
                    </div>
                    <p class="text_area">
                    <div class="description">
                        <span class="">${file.description}</span>
                        <span class="tit_sub">
                            <i class="space">时间：${file.time}  </i>
                            <i class="space">大小：${file.size}MB  </i>
                            <i>星级：</i>
                            <i class="star">
                                <span style="width: ${file.star/5*100}%"></span>
                            </i>
                        </span>
                    </div>
                    </p>
                </div>
                <div class="div_down">
                <a class="download" href="DownloadServlet?filename=${file.name}" title="点击下载">下载</a>
                </div>
            </li>
        </ul>
    </c:forEach>
    <p class="back"><a href="main.jsp">返回首页</a></p>
</div>

</body>
</html>
