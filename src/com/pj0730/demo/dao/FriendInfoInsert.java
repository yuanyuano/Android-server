package com.pj0730.demo.dao;

import com.pj0730.demo.po.Friend;
import com.pj0730.demo.po.FriendInsertInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendInfoInsert {

    public Friend findFriendbyId(FriendInsertInfo friendInsertInfo) {
        int friendID = 0;
        Friend friend = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT hostinfo.hostID,hostinfo.hostAvatar, hostinfo.hostNick, sign.sign FROM hostinfo INNER JOIN sign ON hostinfo.hostID=sign.hostID WHERE hostinfo.hostID="+friendInsertInfo.getFriendID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                friendID = rs.getInt("hostID");
                friend =new Friend(
                        rs.getString("hostAvatar"),
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
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(friendID == friendInsertInfo.getFriendID())
            return friend;
        else
            return null;
    }

    public int insert(FriendInsertInfo insertinfo) {

        Friend info = new FriendInfoInsert().findFriendbyId(insertinfo);
        int flag = -1;
        Connection conn = null;
        Statement st = null;
        String sql = "INSERT INTO friend(fhostID,friend.friendID,avatar,Nick)VALUES("+insertinfo.getHostID()+","+insertinfo.getFriendID()+",'"+info.getAvatar()+"','"+info.getNick()+"')";
        System.out.println(sql);
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

    public Friend findFriend(FriendInsertInfo friendInsertInfo) {
            Friend friend = null;
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            String sql = "SELECT hostinfo.hostAvatar, hostinfo.hostNick,sign.sign FROM hostinfo INNER JOIN sign ON hostinfo.hostID=sign.hostID WHERE hostinfo.hostID=" + friendInsertInfo.getFriendID();
            try {
                conn = new DBUtils().getConnection();
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    friend = new Friend(
                            rs.getString("hostAvatar"),
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
            return friend;
        }


    public int checkFriend(FriendInsertInfo friendInsertInfo){
        int flag = 0;
        FriendInsertInfo info = new FriendInsertInfo(0,0);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT fhostID,friendID FROM friend WHERE fhostID="+friendInsertInfo.getHostID()+" && friendID="+friendInsertInfo.getFriendID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                info = new FriendInsertInfo(
                        rs.getInt("fhostID"),
                        rs.getInt("friendID")
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
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(info.getHostID()==0 && info.getFriendID()==0){
            return flag;
        }
        else{
            flag = 1;
            return flag;
        }
    }
}