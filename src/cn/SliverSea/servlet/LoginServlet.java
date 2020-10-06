package cn.SliverSea.servlet;

import cn.SliverSea.dao.UserDao;
import cn.SliverSea.pojo.File;
import cn.SliverSea.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");
        UserDao userDao = new UserDao();
        User user = userDao.get(username);

        if (new UserDao().vetifyAdminUser(username, password)) {
            HttpSession session = request.getSession();
            String sessionCode = (String) session.getAttribute("safecode");
//            System.out.println(sessionCode);
//            System.out.println(verifycode);
            if (!(sessionCode.equals(verifycode))) {
                request.setAttribute("Msg", "你验证码错了");
                // request.getRequestDispatcher("index.jsp").forward(request,response);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            String parameter = request.getParameter("tenDayLogin");
            if ("ok".equals(parameter)) {//说明用户选择了免登陆
                //创建Cookie对象

                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                //设置有效时间
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                //设置关联路径,默认根路径就行
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                //发送Cookie给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                session.setAttribute("CurrentUser", user);
                response.sendRedirect("main.jsp");
            } else {
                session.setAttribute("CurrentUser", user);
                response.sendRedirect("main.jsp");

            }
        } else {
            //账号密码错误
            request.setAttribute("Msg", "账号密码错误");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
