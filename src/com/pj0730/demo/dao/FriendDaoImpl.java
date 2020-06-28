package com.pj0730.demo.dao;

import com.pj0730.demo.po.AllInfo;
import com.pj0730.demo.po.Friend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class FriendDaoImpl {
    public String findsign(int hostID) {
        String sign="";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT sign FROM sign WHERE hostID="+hostID;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                sign = rs.getString("sign");
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
        return sign;
    }

    public List<Friend> findFriend(int hostID){
        String sql = "SELECT friend.friendID,friend.avatar,friend.Nick FROM friend INNER JOIN hostinfo ON friend.fhostID = hostinfo.hostID WHERE hostID="+hostID;
        List<Friend> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {   int friendID = rs.getInt("friendID");
                String sign = new FriendDaoImpl().findsign(friendID);
                Friend friend =new Friend(
                        rs.getString("avatar"),
                        rs.getString("Nick"),
                        sign
                );
                list.add(friend);
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
