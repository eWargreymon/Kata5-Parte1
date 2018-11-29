package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException {
        
        String url  = "jdbc:sqlite:KATA5.db";
        String sql = "CREATE TABLE EMAIL (\n"
                + "Id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "Mail text NOT NULL)";
        
        try{ Connection conn = DriverManager.getConnection(url);
            Statement stm = conn.createStatement();
            stm.execute(sql);
            System.out.println("Se ha creado la tabla EMAIL");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
