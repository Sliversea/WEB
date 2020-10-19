package cn.SliverSea.servlet;

import cn.SliverSea.dao.UserDao;
import cn.SliverSea.pojo.File;
import cn.SliverSea.pojo.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxLoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");
        String tenDayLogin = request.getParameter("tenDayLogin");

        HttpSession session = request.getSession();
        String saveVCode = (String) session.getAttribute("safecode");
        Map<String,Object> map = new HashMap<String,Object>();
        if (!verifycode.equalsIgnoreCase(saveVCode)){
            map.put("code",1);
            map.put("info","验证码不正确");
        }else {
            UserDao userDao = new UserDao();
            User user = userDao.get(username);
            if (user == null){
                map.put("code",1);
                map.put("info","用户名不存在");
            }else {
                if (!user.getPassword().equals(password)){
                    map.put("code",3);
                    map.put("info","密码不正确");
                }else {
                    session.setAttribute("currentUser",user);
                    if (tenDayLogin != null){
                        Cookie cookie1 = new Cookie("username",username);
                        cookie1.setMaxAge(7*24*24*24);
                        response.addCookie(cookie1);
                        Cookie cookie2 = new Cookie("password",password);
                        cookie1.setMaxAge(7*24*24*24);
                        response.addCookie(cookie2);
                    }
                    map.put("code",0);
                    map.put("info","登陆成功");
                }
            }
        }

        String jsonStr = new Gson().toJson(map);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
