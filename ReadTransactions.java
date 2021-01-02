package Dataware;

import java.util.*;
import java.util.Date;
import java.sql.*;
public class ReadTransactions  
{
	public static String DBURL = "jdbc:mysql://localhost:3306/";
	public static String DBUSER = "root";
	public static String DBPASS = "root1234";
	
	ReadTransactions() throws SQLException
	{
		
		
		
	}
	
	@SuppressWarnings("null")
	public ResultSet Read_Trans_Data() throws SQLException
	{
		
		
		Connection con =  getCon();
		
		String query = "SELECT * FROM metro_db.transactions LIMIT 5";
		
		//PreparedStatement ps=con.prepareStatement(query);
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		return rs;
		
		
		/*
		 * while (rs.next()) { int TRANSACTION_ID=rs.getInt("TRANSACTION_ID"); String
		 * PRODUCT_ID = rs.getString("PRODUCT_ID"); String CUSTOMER_ID =
		 * rs.getString("CUSTOMER_ID"); String CUSTOMER_NAME =
		 * rs.getString("CUSTOMER_NAME"); String STORE_ID = rs.getString("STORE_ID");
		 * String STORE_NAME = rs.getString("STORE_NAME"); Date T_DATE =
		 * rs.getDate("T_DATE"); int QUANTITY = rs.getInt("QUANTITY");
		 * 
		 * // print the results
		 * System.out.format("%s, %s, %s, %s, %s, %s, %s, %s \n",TRANSACTION_ID,
		 * PRODUCT_ID ,CUSTOMER_ID,CUSTOMER_NAME,STORE_ID,STORE_NAME, T_DATE,QUANTITY);
		 */
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
	

