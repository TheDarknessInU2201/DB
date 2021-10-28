package com.db.connectionAndQuerys;
    import java.sql.*;

public class cratemaintables {
    Connector con = new Connector();
    Querys q = new Querys();
    public void createmain() {
        Boolean tab = checktablecreated("media");
        Boolean tabTyp = checktablecreated("Typen");
        if(!tab && !tabTyp){
            q.createTable("media", "STR_Hash text NOT NULL, STR_Pfad text, I_Storage int, I_Typ int, STR_Name text, STR_Dateiendung text");
            q.createTable("typen", "STR_Hash text NOT NULL, STR_Typ text, I_Typ int, STR_Dateierweiterung text");
        }
    }
    public Boolean checktablecreated(String tablename){
        Boolean x= false;
        Connection conn;
        conn = con.connect();
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet table = meta.getTables(null,null,tablename, null);
                if(table.next()){
                    x=true;
                System.out.println("Tabelle '"+tablename+"' existiert.");
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }
}
