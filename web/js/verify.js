function login(){
    $.ajax({
        url:'AjaxLoginCheckServlet',
        type:"POST",
        data:{
            username:$("#username").val(),
            password:$("#password").val(),
            verifycode:$("#verifycode").val()
        },
        dataType:"json",
        success:function(response){
            if(response.code == 0){
                window.location.href = "main.jsp";
            }else {
                $("#checkError").text(response.info);
            }
        }

    });
}