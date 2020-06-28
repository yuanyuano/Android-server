package com.pj0730.demo.dao;

import com.pj0730.demo.po.HostInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.pj0730.demo.po.Friend;

public class MainDaoImpl {
    public Friend findhost(int hostID) {
        Friend host = null;
        String sql = "SELECT hostinfo.hostavatar,hostinfo.hostNick,sign.sign FROM hostinfo INNER JOIN sign on hostinfo.hostID = sign.hostID WHERE hostinfo.hostID=" + hostID;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
               host = new Friend(
                        rs.getString("hostavatar"),
                        rs.getString("hostNick"),
                        rs.getString("sign")

                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return host;
    }
}
