$(function () {
    Victor("container", "output");   //登录背景函数
    $("#entry_name").focus();
    $(document).keydown(function (event) {
        if (event.keyCode == 13) {
            $("#entry_btn").click();
        }
    });
});