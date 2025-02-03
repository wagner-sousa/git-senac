
import java.sql.Connection;
import java.sql.DriverManager;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB() throws Exception {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://mysql-database:3306/auction?user=root&password=root@123");
        return conn;
    }
    
}
