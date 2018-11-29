package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException {
        
        Connection conn = null;
        String url  = "jdbc:sqlite:KATA5.db";
        conn = DriverManager.getConnection(url);
        System.out.println("Conexión establecida");
        String sql = "SELECT * FROM PEOPLE";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t" +
                                rs.getString("Name") + "\t" +
                                rs.getString("Apellidos") + "\t" +
                                rs.getString("Departamento") + "\t" );
        }
        
    }
}
