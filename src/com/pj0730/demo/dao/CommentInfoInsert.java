package com.pj0730.demo.dao;

import com.pj0730.demo.po.CommentInfo;
import com.pj0730.demo.po.CommentInsertInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentInfoInsert {
    public CommentInfo findCommentbyId(CommentInsertInfo commentInsertInfo) {
        CommentInfo commentInfo = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT hostAvatar,hostNick FROM hostinfo WHERE hostID="+commentInsertInfo.getHostID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                commentInfo =new CommentInfo(
                        commentInsertInfo.getHostID(),
                        commentInsertInfo.getDynamicID(),
                        rs.getString("hostAvatar"),
                        rs.getString("hostNick"),
                        commentInsertInfo.getTime(),
                        commentInsertInfo.getCom_content()
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
        return commentInfo;
    }






    public int insert(CommentInsertInfo insertinfo) {

        CommentInfo info = new CommentInfoInsert().findCommentbyId(insertinfo);
        info.toString();
        int flag = -1;
        Connection conn = null;
        Statement st = null;
        String sql = "INSERT INTO comment(hostID,dynamicID,hostAvatar,hostNick,createTime,com_textFiled)VALUES('"+info.getHostID()+"','"+info.getDynamicID()+"','"+info.getHostAvatar()+"','"+info.getHostNick()+"','"+info.getCreateTime()+"','"+info.getCom_textFiled()+"')";
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
}
