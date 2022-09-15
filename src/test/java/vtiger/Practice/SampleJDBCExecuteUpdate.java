package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
		Driver driverref = new Driver();
		// Step 1 : register the driver/database
		DriverManager.registerDriver(driverref);
		//Step 2 : get the connection with database 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
		//Step 3 : issue create statement 
		Statement state = con.createStatement();
		//Step 4 : execute the query 
		String query = "insert into customerinfo values('Abhinav',15,'Mumbai');";
		int result = state.executeUpdate(query);
		if(result==1) {
			System.out.println("the data is inserted");
		}
		else {
			System.out.println("the data is not inserted");
		}
		}
		catch(Exception e) {
			
		}
		//Step 5 : close the database
		finally {
		con.close();
		System.out.println("database is successfully closed");
		}

	}

}
