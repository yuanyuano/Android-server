package com.pj0730.demo.dao;

import com.pj0730.demo.po.CommentInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl {
    public List<CommentInfo> findCommentPage(int dynamicID){
        String sql = "SELECT comment.hostID, moment.dynamicID,comment.hostAvatar,comment.hostNick, comment.createTime, comment.com_textFiled FROM moment INNER JOIN comment ON moment.dynamicID = comment.dynamicID  WHERE moment.dynamicID="+dynamicID;
        List<CommentInfo> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {

                CommentInfo all = new CommentInfo(
                        rs.getInt("hostID"),
                        rs.getInt("dynamicID"),
                        rs.getString("hostAvatar"),
                        rs.getString("hostNick"),
                        rs.getString("createTime"),
                        rs.getString("com_textFiled")
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
