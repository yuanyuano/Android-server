package com.pj0730.demo.dao;

import com.pj0730.demo.po.CollectInfo;
import com.pj0730.demo.po.CommentInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CollectedUpdate {
    public void insertcollected(CollectInfo info) {
        int ida = info.getDynamicID();
        int idb = info.getHostID();
        Connection conn = null;
        Statement st = null;
        String sql = "INSERT INTO collectlist(dynamicID,hostID,isCollected)VALUES(" + info.getDynamicID() + "," + info.getHostID() + ",1)";
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

    public void tocollected(CollectInfo info) {
        Connection conn = null;
        Statement st = null;

        String sql = "UPDATE collectlist SET isCollected='1' WHERE dynamicID=" + info.getDynamicID() + " && hostID=" + info.getHostID();
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

    public void cancelcollected(CollectInfo info) {
        Connection conn = null;
        Statement st = null;

        String sql = "UPDATE collectlist SET isCollected='-1' WHERE dynamicID=" + info.getDynamicID() + " && hostID=" + info.getHostID();
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

    public int findCollected(CollectInfo info) {
        int isCollected = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT isCollected FROM collectlist WHERE dynamicID=" + info.getDynamicID() + " && hostID=" + info.getHostID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                isCollected = rs.getInt("isCollected");
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
        if (isCollected == 0) {
            new CollectedUpdate().insertcollected(info);

            isCollected = 1;

            return isCollected;
        } else if(isCollected == -1)
        {
            new CollectedUpdate().tocollected(info);
            isCollected = 1;
            return isCollected;
        }
        else
        {
            new CollectedUpdate().cancelcollected(info);
            isCollected = -1;
            return isCollected;
        }
    }

}
