package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
     public static Connection getMySQLConnection() throws SQLException,
     ClassNotFoundException 
     {
         final String hostName = "localhost";
         final String dbName = "test";
         final String userName = "root";
         final String password = "123456";

         return getMySQLConnection(hostName, dbName, userName, password);
     }

    public static Connection getMySQLConnection(String hostName, String dbName,String userName, String password)
    throws SQLException, ClassNotFoundException
    {
         Class.forName("com.mysql.cj.jdbc.Driver");

         String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

         Connection conn = DriverManager.getConnection(connectionURL, userName,
                 password);
         return conn;
    }
    
    public static void main(String[] args) {
		try {
			new DBConnection();
			System.out.println(DBConnection.getMySQLConnection());
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}
