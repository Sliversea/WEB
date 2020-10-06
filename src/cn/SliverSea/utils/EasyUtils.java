package cn.SliverSea.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EasyUtils {
    /**
     * 获取表中数据总数
     *
     * @param sql
     * @return
     */
    public static int getCount(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.first()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.destoryConnection(rs, ps, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 是否返回了数据
     *
     * @param sql
     * @return
     */
    public static boolean hasData(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs.first();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.destoryConnection(rs, ps, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 获取增删改结果
     *
     * @param sql
     * @return
     */
    public static boolean getUpdateResult(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.execute();
            return ps.getUpdateCount() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.destoryConnection(null, ps, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 获取第一个数据
     *
     * @param sql
     * @return
     */
    public static String getFirstData(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.first()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.destoryConnection(rs, ps, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
