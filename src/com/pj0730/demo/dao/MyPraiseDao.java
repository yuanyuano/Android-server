package com.pj0730.demo.dao;

import com.pj0730.demo.po.MyPraised;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyPraiseDao {
    public List<MyPraised> findMyPraise(int hostID){
        int isPraised = 1;
        String sql = "SELECT hostinfo.hostAvatar,hostinfo.hostNick,moment.createTime,moment.mom_image FROM (hostinfo INNER JOIN praisedlist on hostinfo.hostID = praisedlist.hostID)INNER JOIN moment ON praisedlist.dynamicID=moment.dynamicID WHERE mhostID="+hostID+" && isPraised="+isPraised;
        List<MyPraised> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {

                MyPraised myPraised = new MyPraised(
                        rs.getString("hostAvatar"),
                        rs.getString("hostNick"),
                        rs.getString("createTime"),
                        rs.getString("mom_image")
                );
                list.add(myPraised);
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
