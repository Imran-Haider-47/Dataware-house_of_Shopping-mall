package Dataware;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class ReadMasterData {
	public static String DBURL = "jdbc:mysql://localhost:3306/";
	public static String DBUSER = "root";
	public static String DBPASS = "root1234";
	
	//Constructor
	ReadMasterData() throws SQLException
	{
		
		
	}
	
	
	public ResultSet Get_Master_Data(String Pid) throws SQLException
	{
		
		Connection conn = getCon();
		Statement statement1= null;
		
		statement1 = conn.createStatement();
		String query = "(SELECT * FROM metro_db.masterdata where PRODUCT_ID= ? )";
		PreparedStatement pss=conn.prepareStatement(query);
		pss.setString(1, Pid);
		//System.out.println("Query= "+pss);
		ResultSet rs=pss.executeQuery();
		return rs;
		
	}
	
	public Connection getCon() {
		try {
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			e.printStackTrace(System.out); 
			return null;
		}
	}
	

	
}
