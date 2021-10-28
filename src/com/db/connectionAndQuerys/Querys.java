package com.db.connectionAndQuerys;

import java.sql.*;

public class Querys {

    String str = null;
    Connector con = new Connector();

    public String createTable(String tablename, String spalten) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = con.connect();
            stmt = conn.prepareStatement("CREATE TABLE " + tablename + " (LID int NOT NULL PRIMARY KEY, " + spalten + ")");
            stmt.executeUpdate();

            str = "Table created";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public String insertData(String tablename, String spalten) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = con.connect();
            stmt = conn.prepareStatement("CREATE TABLE " + tablename + " (LID int NOT NULL PRIMARY KEY, " + spalten + ")");
            stmt.executeUpdate();

            str = "Table created";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}