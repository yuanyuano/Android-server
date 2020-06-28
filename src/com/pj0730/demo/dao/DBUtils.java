package com.pj0730.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static String DRIVER="com.mysql.jdbc.Driver";
    public static String URL="jdbc:mysql://127.0.0.1:3306/wechat";
    public static String USER="root";
    public static String PASSWORD="ggkk12040627";
    private Connection conn;
    public DBUtils() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  Connection getConnection(){
        return conn;
    }
}
