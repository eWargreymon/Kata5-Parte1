package kata5p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import static kata5p1.MailListReader.read;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException, IOException {
        
       String url = "jdbc:sqlite:KATA5.db";
       String path = "C:\\Users\\eddyh\\Desktop\\Kata5P1\\email.txt";
       List<String> emails = read(path);
       String sql= "INSERT INTO EMAIL(Mail) VALUES(?)";
       try{ Connection conn = DriverManager.getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            Iterator<String> it = emails.iterator();
            while(it.hasNext()){
                pst.setString(1, it.next());
                pst.executeUpdate();
            }
       }catch(SQLException e) {
           System.out.println(e.getMessage());
       }
    }
}
