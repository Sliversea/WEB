function logout() {
    if (confirm("您确定要退出控制面板吗？"))
        top.location = "index.jsp";
    return false;
}