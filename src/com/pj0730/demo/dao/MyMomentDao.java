package com.pj0730.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pj0730.demo.po.AllInfo;

public class MyMomentDao {
    public int findpraised(int hostID, int dynamicID) {
        int isPraised = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT isPraised FROM praisedlist WHERE hostID="+hostID+" && dynamicID="+dynamicID;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                isPraised = rs.getInt("isPraised");
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
        return isPraised;
    }

    public int findcollected(int hostID, int dynamicID) {
        int iscollected = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT isCollected FROM collectlist WHERE hostID="+hostID+" && dynamicID="+dynamicID;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                iscollected = rs.getInt("isCollected");
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
        return iscollected;
    }

    public List<AllInfo> findMyMoment(int hostID){
        String sql = "SELECT moment.dynamicID,hostinfo.hostAvatar,hostinfo.hostNick,moment.createTime,moment.mom_textField,moment.mom_image,moment.hasPraised FROM hostinfo INNER JOIN moment ON hostinfo.hostID=moment.mhostID WHERE hostID="+hostID;
        List<AllInfo> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                int dynamicID = rs.getInt("dynamicID");
                AllInfo all = new AllInfo(
                        dynamicID,
                        rs.getString("hostAvatar"),
                        rs.getString("hostNick"),
                        rs.getString("createTime"),
                        rs.getString("mom_textField"),
                        rs.getString("mom_image"),
                        rs.getInt("hasPraised"),
                        new MyMomentDao().findcollected(hostID,dynamicID),
                        new MyMomentDao().findpraised(hostID,dynamicID)
                );
                list.add(all);
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
        return list;
    }
}
