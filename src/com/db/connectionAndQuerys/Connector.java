package com.db.connectionAndQuerys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public Connection connect() {
        Connection conn = null;
        try {
            String dbURL = "jdbc:postgresql://localhost:5432/Media";
            String user = "Superuser"; //exemple Superuser
            String pass = "Password"; //exemple password

            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                System.out.println("Connected to database");
            }
            return conn;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

