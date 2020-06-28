package com.pj0730.demo.dao;

import com.pj0730.demo.po.AllInfo;

import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.sql.Date;
        import java.util.List;
public class DaoImpl {
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

    public List<AllInfo> findMainPage(int hostID){
        String sql = "SELECT moment.dynamicID, friend.avatar,friend.Nick, moment.createTime, moment.mom_textField, moment.mom_image, moment.hasPraised FROM moment INNER JOIN friend ON moment.mhostID = friend.friendID WHERE fhostID="+hostID;
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
                        rs.getString("avatar"),
                        rs.getString("Nick"),
                        rs.getString("createTime"),
                        rs.getString("mom_textField"),
                        rs.getString("mom_image"),
                        rs.getInt("hasPraised"),
                        new DaoImpl().findcollected(hostID,dynamicID),
                        new DaoImpl().findpraised(hostID,dynamicID)
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
