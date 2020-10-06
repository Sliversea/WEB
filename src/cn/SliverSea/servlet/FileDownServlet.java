package cn.SliverSea.servlet;


import cn.SliverSea.dao.UserDao;
import cn.SliverSea.pojo.File;
import cn.SliverSea.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FileDownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        FileDao fileDao = new FileDao();
//        List<File> list = fileDao.getallFile();
//        HttpSession session = request.getSession();
//        session.setAttribute("filelist",list);
//        response.sendRedirect("download.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from t_downloadlist";
        List<File> list = new ArrayList<File>();
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                File file = new File();
                file.setId(resultSet.getInt("id"));
                file.setTime(resultSet.getDate("time"));
                file.setDescription(resultSet.getString("description"));
                file.setName(resultSet.getString("name"));
                file.setSize(resultSet.getFloat("size"));
                file.setStar(resultSet.getInt("star"));
                file.setImages(resultSet.getString("images"));
                list.add(file);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("filelist",list);
        response.sendRedirect("download.jsp");
    }
}
