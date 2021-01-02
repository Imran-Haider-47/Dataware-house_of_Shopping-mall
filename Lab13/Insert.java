import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Insert {

	public static String DBURL = "jdbc:mysql://localhost:3306/";
	public static String DBUSER = "root";
	public static String DBPASS = "root1234";
	
	public static void main(String[] args) throws ParseException, SQLException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Current Date"+getCurrentDate());
        
		
		
		//To take first name as an input
		System.out.println("Enter First Name ");
		String fname=scan.nextLine();
		scan.nextLine();
		//To take last name as an input 
		System.out.println("Enter Last Name ");
		String lname=scan.nextLine();
		scan.nextLine();
		//To take employee id as an input
		System.out.println("Enter the Employee id. It should be greater than 211.");
		int EmployeeID=scan.nextInt();
		scan.nextLine();
		
	
		
		// input the email address
		System.out.println("Enter Email ");
		String email=scan.nextLine();
		scan.nextLine();
		
		//input the phone number
		System.out.println("Enter phone number (format: 515.123.1414");
		String phone=scan.nextLine();
		scan.nextLine();
		
		
		String lastCrawlDate = "2014-01-28";
		Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		// because PreparedStatement#setDate(..) expects a java.sql.Date argument
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
        //Enter job id
		System.out.println("Enter job id ");
		String JobID=scan.nextLine();
		
		//Enter the Salary
		System.out.println("Enter the salary");
		float Salary=scan.nextFloat();
		
		//commission percentage
		float CommissionPerc=(float) 0.0;
		
		int ManagerID=100;
		int DepartmentID=90;
		
		
		
		Statement statement=null;
		Connection con = getCon();
		statement  = con.createStatement();
		String query = "insert into company.employees "
				+ "Values(?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		
		ps.setInt(1,EmployeeID);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setString(4, email);
		ps.setString(5, phone);
		ps.setDate(6,  sqlDate);
		ps.setString(7,JobID);
		ps.setFloat(8, Salary);
		ps.setFloat(9,CommissionPerc);
		ps.setInt(10,ManagerID);
		ps.setInt(11, DepartmentID);
		
		int rows=ps.executeUpdate();
		
		System.out.println(rows+" Record inserted ");
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

	public static ResultSet getRS(Connection con, String querry) {
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(querry);
		    statement.close();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			return null;
		}
	}

	public static void Close(Connection con, ResultSet rs) {
		try {
			rs.getStatement().close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	

}


/*try {
while (rs.next()) {			
//	System.out.println(rs.getInt(1)+". "+rs.getString(2)+"      "+rs.getString(3)+"  "+rs.getString(4)
	+"    " +rs.getInt(5) +1 );
}*/
/*
* }catch (SQLException e) { e.printStackTrace(System.out); }
*/

//Connection myconn = null;
//Statement st = null;
//
//try {
//myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", user, pass);
//st = myconn.createStatement();
//int r = st.executeUpdate("insert into world.city " + "VALUES(9001, 'RWP', 'PAK', 'ABCD',19290)" + ","
//		+ "(9002, 'ISB', 'PAK', 'ABCD', 69290)");
//System.out.println("Effected rows are " + r);
//myconn.close();
//} catch (Exception e) {
//System.err.println("Get an exception");
//System.err.println(e.getMessage());
//}
