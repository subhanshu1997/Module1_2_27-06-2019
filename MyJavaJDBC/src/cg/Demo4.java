package cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) throws SQLException {
	try {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected");
		con.setAutoCommit(false);//tells that do not commit after every dml statement
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Account Id");
		int id=sc.nextInt();
		System.out.println("Enter Mobile No.");
		long mb=sc.nextLong();
		System.out.println("Enter Account Holder Name");
		String ah=sc.next();
		System.out.println("Enter Initial Balance");
		double bal=sc.nextDouble();
		String sqlquery="insert into account values(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sqlquery);
		st.setInt(1,id);
		st.setLong(2,mb);
		st.setString(3,ah);
		st.setDouble(4,bal);
		int insertedRec=st.executeUpdate();
		System.out.println("Inserted Record"+insertedRec);
		con.commit();
		con.close();
	} catch (SQLException e) {
		System.out.println(e.getMessage()+""+e.getErrorCode()+""+e.getSQLState());
		e.printStackTrace();
	}	

}
}
