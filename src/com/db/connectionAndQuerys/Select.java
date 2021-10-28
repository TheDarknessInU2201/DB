package com.db.connectionAndQuerys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

    String str = null;
    Connector con = new Connector();

    public String Select(String selectstatement) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;

        try {
            conn = con.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectstatement);
            while (rs.next()) {

            }
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