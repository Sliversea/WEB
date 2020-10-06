package cn.SliverSea.filter;

import cn.SliverSea.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginFilter implements Filter {
    private String notCheckPath;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");
        String path = request.getServletPath();
        System.out.println("url-pattern" + path);
        //请求资源在拦截列表
        Cookie[] cookies = request.getCookies();
        if (notCheckPath.indexOf(path) == -1) {
            HttpSession session = request.getSession();
            if (cookies == null) {
                request.setAttribute("Msg", "没有权限访问");
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } else {
                chain.doFilter(req, resp);
            }
        } else {
            chain.doFilter(req, resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

        notCheckPath = config.getInitParameter("notCheckpath");
    }

}
