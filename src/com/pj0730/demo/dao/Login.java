package com.pj0730.demo.dao;

import com.pj0730.demo.po.HostInfo;
import com.pj0730.demo.po.LoginInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    public int findLogin(HostInfo info){
        int flag = -1;
        LoginInfo login = null;
        String sql = "SELECT hostID, password FROM hostinfo WHERE hostID="+info.getHostID();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                login = new LoginInfo(
                        rs.getInt("hostID"),
                        rs.getString("password")
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
        System.out.println(info.getHostID());
        if((info.getHostID() == login.getHostID()) && (info.getPassword().equals(login.getPassword())))
        {
            flag = 1;
            return flag;
        }
        else return flag;
    }

}