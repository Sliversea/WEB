package cn.SliverSea.servlet;

import cn.SliverSea.dao.UserDao;
import cn.SliverSea.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;


public class CheckCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        boolean flag = false;
        PrintWriter out = response.getWriter();
        // 判断cookie是否有username，如果有代表登陆过
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(URLDecoder.decode(cookie.getName(), "utf-8"));
                if (URLDecoder.decode(cookie.getName(), "utf-8").equals("username")) { // 表明已经登陆过了，就直接跳转了
                    flag = true;
                }
            }
        }
        if (flag) {
            response.sendRedirect("main.jsp");

        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
