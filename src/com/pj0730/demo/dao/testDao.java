package com.pj0730.demo.dao;

import com.pj0730.demo.po.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class testDao {
    public test test(int hostID) {
        test t = null;
        String sql = "SELECT Nick,avatar FROM friend WHERE friendID=" + hostID;
        List<test> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                 t = new test(
                        rs.getString("Nick"),
                        rs.getString("avatar")

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
        return t;
    }
}
