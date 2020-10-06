package cn.SliverSea.dao;

import cn.SliverSea.pojo.User;
import cn.SliverSea.utils.DBUtils;
import cn.SliverSea.utils.EasyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean vetifyAdminUser(String username, String password) {
        String sqlStr = "SELECT * FROM t_user WHERE userName='" + username + "' AND password='" + password + "'" ;
        return EasyUtils.hasData(sqlStr);
    }


    public User get(String username){
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.getConnection();
            String sql = "SELECT * FROM t_user where userName=?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user = new User(resultSet.getString("userName"),resultSet.getString("password"),resultSet.getString("name"));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }return user;
    }



}
