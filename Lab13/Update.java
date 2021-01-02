import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Update {
	public static String DBURL = "jdbc:mysql://localhost:3306/";
	public static String DBUSER = "root";
	public static String DBPASS = "root1234";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Department ID:");
		
		Scanner scan=new Scanner(System.in);
		
		int DepartmentID=scan.nextInt();
		scan.nextLine();
		
		Statement statement=null;
		Connection con = getCon();
		statement  = con.createStatement();
		String query = "update company.departments"
				+" set department_id=?, department_name='IT', manager_id=204,location_id=1700"
				+" where department_id=15";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, DepartmentID);
		System.out.println("PS= "+ps);
		int row= ps.executeUpdate();
		System.out.println(row+" row  has been updated.");
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
