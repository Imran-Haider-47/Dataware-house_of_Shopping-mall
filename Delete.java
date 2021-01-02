package Dataware;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Delete {
	public static String DBURL = "jdbc:mysql://localhost:3306/";
	public static String DBUSER = "root";
	public static String DBPASS = "root1234";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Product_ID you want to Delete: ");
		Scanner scan = new Scanner(System.in);
		
		int ProductID=scan.nextInt();
		Statement statement=null;
		Connection con = getCon();
		statement  = con.createStatement();
		String query = "DELETE FROM company.Products where ProductID=?";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, ProductID);
		System.out.println("PS= "+ps);
		ps.executeUpdate();
		
		con.close();
		
	}
	
	public static Connection getCon() {
		try {
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			e.printStackTrace(System.out); 
			return null;
		}
	}


}
