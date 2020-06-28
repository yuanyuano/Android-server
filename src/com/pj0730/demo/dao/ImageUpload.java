package com.pj0730.demo.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImageUpload {
    public String finduseimage(int dynamicID){
        String image="0";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT mom_image FROM moment WHERE dynamicID="+dynamicID;
        try{
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){

               image = rs.getString("mom_image");
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
           return image;
       }


    public int avatar(String filename, String hostID){
        int flag = -1;
        Connection conn = null;
        Statement st = null;
        int id = Integer.parseInt(hostID);
        String sql = "UPDATE hostinfo SET hostAvatar='"+filename+"'WHERE hostID="+id;
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
    public int image(String filename, String dynamicID){
        int flag = -1;
        Connection conn = null;
        Statement st = null;
        String sql = "";
        int id = Integer.parseInt(dynamicID);
        String use_image = new ImageUpload().finduseimage(id);
         sql = "UPDATE moment SET mom_image='"+use_image+"|"+filename+"'WHERE dynamicID="+id;
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
