package com.pj0730.demo.dao;

import com.pj0730.demo.po.HostInfo;
import com.pj0730.demo.po.HostInsertInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class HostInfoInsert {
    public void inserthost(int hostID){
        Connection conn = null;
        Statement st = null;
        String sql = "INSERT INTO sign(hostID,sign) VALUES("+hostID+",'')";
        System.out.println(sql);
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            st.executeUpdate(sql);
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

    }

    public int insert(HostInfo info) {

        int flag = -1;
        new HostInfoInsert().inserthost(info.getHostID());
        Connection conn = null;
        Statement st = null;
        String sql = "INSERT INTO hostinfo VALUES('"+info.getHostID()+"','"+info.getHostNick()+"','"+info.getHostAvatar()+"','"+info.getPassword()+"')";
        System.out.println(sql);
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            flag= st.executeUpdate(sql);
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
