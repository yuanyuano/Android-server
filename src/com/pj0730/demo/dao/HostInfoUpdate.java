package com.pj0730.demo.dao;

import com.pj0730.demo.po.HostInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class HostInfoUpdate {
    public int update(HostInfo hostInfo) {
        int flag = -1;
        Connection conn = null;
        Statement st = null;
        String sql = "UPDATE hostinfo SET hostNick='"+hostInfo.getHostNick()+"' WHERE hostID = "+hostInfo.getHostID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            flag = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
