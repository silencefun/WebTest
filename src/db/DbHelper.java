package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelper {
	 public static final String url = "jdbc:mysql://localhost/world";    
     public static final String name = "com.mysql.jdbc.Driver";    
     public static final String user = "root";    
     public static final String password = "000000";    
     
     public Connection conn = null;    
     public PreparedStatement pst = null;    
     
     public DbHelper(String sql) {    
         try {    
             Class.forName(name);//  
             conn = DriverManager.getConnection(url, user, password);//  
             pst = conn.prepareStatement(sql);//  
         } catch (Exception e) {  
        	 System.err.println(e.getMessage());
             e.printStackTrace();    
         }    
     }    
     
     public void close() {    
         try {    
             this.conn.close();    
             this.pst.close();    
         } catch (SQLException e) {    
             e.printStackTrace();    
         }    
     }    

}
