package cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected!!!");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from account");
		while(rs.next()) {
			int a_id=rs.getInt("aid");
			long mobile=rs.getLong("mobileno");
			String name=rs.getString(3);
			double balance=rs.getDouble(4);
			System.out.println("Account id: "+a_id+"Mobile no.: "+mobile+"Name: "+name+"Balance: "+balance);
		}
		con.close();
	}

}
