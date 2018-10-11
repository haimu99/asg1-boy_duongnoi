package sample.Dictionary;
import java.sql.*;
public class DatabaseCollection {
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String password = "";
            return DriverManager.getConnection("jdbc:mysql://localhost:8888/Eng-Viet_Dictionary?autoReconnect=true&useSSL=false", "root", password);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
