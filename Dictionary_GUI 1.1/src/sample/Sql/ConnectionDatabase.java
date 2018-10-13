package sample.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionDatabase {
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:dict_hh.db";
            return DriverManager.getConnection(url);
        }
        catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
