package cn.SliverSea.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session=request.getSession();
//        session.removeAttribute("username");
//        session.invalidate();
//        response.setCharacterEncoding("GBK");
//        response.getWriter().write("<script>alert('您已经安全退出！');window.top.location.href='"+getServletContext().getContextPath()+"/index.jsp';</script>");

        //消除session
        HttpSession session = request.getSession();
        session.invalidate();

        //清除cookie，并且退出
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        //request.getRequestDispatcher("login.jsp").forward(request, response);
        response.sendRedirect("index.jsp");
    }
    }

