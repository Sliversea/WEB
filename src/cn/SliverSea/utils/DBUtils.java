package cn.SliverSea.utils;

import java.sql.*;

public class DBUtils {
    private static final String URL="jdbc:mysql://localhost:3306/excise?characterEncoding=utf-8";//port=3306
    private static final String USER="root";
    private static final String PASSWORD="123456";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //建立连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    //关闭资源
    public static void destoryConnection(ResultSet rs, Statement stat, Connection conn) throws SQLException {
        if(rs!=null){
            rs.close();
        }if(stat!=null){
            stat.close();
        }if(conn!=null){
            conn.close();
        }
    }
}
