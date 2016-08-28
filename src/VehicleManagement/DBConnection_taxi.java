package vehicleManagement;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;


public class DBConnection_taxi {
	 public static Connection getDBConnection() {
	        Connection connection;
	        try {
	        	
				Class.forName("com.mysql.jdbc.Driver");
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi", "root", "");
	            //connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/vehicle","root","0");
	            return connection;
	        } catch (Exception ex) {
	            return null;
	        }//try catch closed
	    }//getDBConnection() closed
}
