

    function changeCode() {
        var codeImg = document.getElementById("codePic");
        codeImg.src = "CheckCodeServlet?ran="+new Date().getTime() + Math.random();
    }
