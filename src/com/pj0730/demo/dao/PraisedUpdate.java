package com.pj0730.demo.dao;

import com.pj0730.demo.po.PraiseInfo;
import com.pj0730.demo.po.PraiseResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PraisedUpdate {
    public void insertpraised(PraiseInfo info) {
        int ida = info.getDynamicID();
        int idb = info.getHostID();
        Connection conn = null;
        Statement st = null;
        String sql = "INSERT INTO praisedlist(dynamicID,hostID,isPraised)VALUES(" + info.getDynamicID() + "," + info.getHostID() + ",1)";
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

    public PraiseResult findpraised(PraiseInfo info) {
        int isPraised = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT isPraised FROM praisedlist WHERE dynamicID=" + info.getDynamicID() + " && hostID=" + info.getHostID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                isPraised = rs.getInt("isPraised");
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
        if (isPraised == 0) {
            new PraisedUpdate().insertpraised(info);
           int new_praisednum = new PraisedUpdate().praisedup(info);
            isPraised = 1;
            PraiseResult result = new PraiseResult(info.getDynamicID(),new_praisednum,isPraised);
            return result;
        } else if(isPraised == -1)
        {
            new PraisedUpdate().topraised(info);
            int new_praisednum = new PraisedUpdate().praisedup(info);
            isPraised = 1;
            PraiseResult result = new PraiseResult(info.getDynamicID(),new_praisednum,isPraised);
            return result;
        }
           else
        {
            new PraisedUpdate().cancelpraised(info);
            int new_praisednum = new PraisedUpdate().praiseddown(info);
            isPraised =-1;
            PraiseResult result = new PraiseResult(info.getDynamicID(),new_praisednum,isPraised);
            return result;
        }
    }

        public void parisedchange(int dynamicID, int new_praisednum) {
        Connection conn = null;
        Statement st = null;

        String sql = "UPDATE moment SET hasPraised='"+new_praisednum+"'WHERE dynamicID="+dynamicID;
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
    public void topraised(PraiseInfo info) {
        Connection conn = null;
        Statement st = null;

        String sql = "UPDATE praisedlist SET isPraised='1' WHERE dynamicID=" + info.getDynamicID() + " && hostID=" + info.getHostID();
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

    public void cancelpraised(PraiseInfo info) {
        Connection conn = null;
        Statement st = null;

        String sql = "UPDATE praisedlist SET isPraised='-1' WHERE dynamicID=" + info.getDynamicID() + " && hostID=" + info.getHostID();
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
//
    }

    public int praisedup(PraiseInfo info){
        int praisednum=0;
        int new_praisednum;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT hasPraised FROM moment WHERE dynamicID="+info.getDynamicID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                praisednum = rs.getInt("hasPraised");

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
        new_praisednum = praisednum+1;
        new PraisedUpdate().parisedchange(info.getDynamicID(),new_praisednum);
        return new_praisednum;
    }
    public int praiseddown(PraiseInfo info){
        int praisednum = 0;
        int new_praisednum;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT hasPraised FROM moment WHERE dynamicID="+info.getDynamicID();
        try {
            conn = new DBUtils().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())

            {
                praisednum = rs.getInt("hasPraised");

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
        new_praisednum = praisednum-1;
        new PraisedUpdate().parisedchange(info.getDynamicID(),new_praisednum);
        return new_praisednum;
    }


}
