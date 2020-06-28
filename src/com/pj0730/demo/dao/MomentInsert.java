package com.pj0730.demo.dao;

import com.pj0730.demo.po.AllInfo;
import com.pj0730.demo.po.Moment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MomentInsert {
    public int GenerateDynamicID(){
        int dynamicID=0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(DISTINCT dynamicID) FROM moment";
        try{
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
            {
            dynamicID = rs.getInt("COUNT(DISTINCT dynamicID)");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
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
        return dynamicID;
    }

    public AllInfo findAllbyId(Moment moment) {
       AllInfo allInfo = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int dynamicID = new MomentInsert().GenerateDynamicID();
        String sql = "SELECT hostAvatar,hostNick FROM hostinfo WHERE hostID="+moment.getHostID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                allInfo =new AllInfo(
                        dynamicID,
                        rs.getString("hostAvatar"),
                        rs.getString("hostNick"),
                        moment.getTime(),
                        moment.getMom_content(),
                        "",
                        0,
                        -1,
                        -1
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
        return allInfo;
    }






    public int insert(Moment insertinfo) {

       AllInfo info = new MomentInsert().findAllbyId(insertinfo);
       int flag = -1;
       int dynamicID = info.getDynamicID()+1;
        Connection conn = null;
        Statement st = null;
        String sql = "INSERT INTO moment(mhostID,dynamicID,createTime,mom_textField,mom_image,hasPraised)VALUES("+insertinfo.getHostID()+","+dynamicID+",'"+info.getCreateTime()+"','"+info.getMom_textField()+"','"+info.getMom_image()+"',"+info.getHasPraised()+")";
        System.out.println(sql);
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            flag=st.executeUpdate(sql);
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
        return dynamicID;
    }
}
