package com.pj0730.demo.dao;

import com.pj0730.demo.po.MyComment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyCommentDao {
    public List<MyComment> findMyComment(int hostID){
        String sql = "SELECT `comment`.hostAvatar,`comment`.hostNick,`comment`.com_textFiled,`comment`.createTime,moment.mom_image FROM `comment` INNER JOIN moment ON `comment`.dynamicID = moment.dynamicID WHERE mhostID = "+hostID;
        List<MyComment> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {

                MyComment myComment = new MyComment(
                       rs.getString("hostAvatar"),
                        rs.getString("hostNick"),
                        rs.getString("com_textFiled"),
                        rs.getString("createTime"),
                        rs.getString("mom_image")
                );
                list.add(myComment);
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
