package com.example.shopsb2c22.dals;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;

@Data
public class Conn {
    public static String MYSQL_URL = "jdbc:mysql://localhost:3306/shop_shoe_b2c?autoReconnect=true&useSSL=false";
    public static String MYSQL_USER = "root";
    public static String MYSQL_PASS = "koodinh@";

    protected Connection conn;
    protected String tableName;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect();
        } catch (Exception e) {

        }
    }

    public boolean connect() {
        try {
            this.conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASS);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {

        }
    }
}
