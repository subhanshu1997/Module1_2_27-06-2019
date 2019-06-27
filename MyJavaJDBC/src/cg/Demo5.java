package cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		PreparedStatement updateSt=null;
		PreparedStatement selectSt=null;
	try {
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());//Java8 automatically load the driver so no need for this statement
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected");
		con.setAutoCommit(false);//tells that do not commit after every dml statement
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Account Id");
		int id=sc.nextInt();
		selectSt=con.prepareStatement("select * from account where aid=?");
		selectSt.setInt(1,id);
		ResultSet rs1=selectSt.executeQuery();
		double bal1=0.0;
		if(rs1!=null) {
			if(rs1.next()) {
				System.out.println(rs1.getString(3));
				bal1=rs1.getDouble("balance");
				System.out.println("Your balance is "+bal1);
			}
		}
		System.out.println("Enter Your Account Id");
		int id1=sc.nextInt();
		selectSt=con.prepareStatement("select * from account where aid=?");
		selectSt.setInt(1,id1);
		ResultSet rs2=selectSt.executeQuery();
		double bal2=0.0;
		if(rs2!=null) {
			if(rs2.next()) {
				System.out.println(rs2.getString(3));
				bal2=rs2.getDouble("balance");
				System.out.println("Your balance is "+bal2);
			}
		}
		System.out.println("Enter Amount to Transfer");
		double amount=sc.nextDouble();
		updateSt=con.prepareStatement("update account set mobileno=?,accountholder=?,balance=? where aid=?");
		updateSt.setLong(1,rs1.getLong("mobileno"));
		updateSt.setString(2,rs1.getString("accountholder"));
		updateSt.setDouble(3,rs1.getDouble("balance")-amount);
		updateSt.setInt(4,rs1.getInt("aid"));
		int i1=updateSt.executeUpdate();
		System.out.println("Account Updated");
		updateSt=con.prepareStatement("update account set mobileno=?,accountholder=?,balance=? where aid=?");
		updateSt.setLong(1,rs2.getLong("mobileno"));
		updateSt.setString(2,rs2.getString("accountholder"));
		updateSt.setDouble(3,rs2.getDouble("balance")+amount);
		updateSt.setInt(4,rs2.getInt("aid"));
		i1+=updateSt.executeUpdate();
		System.out.println("Account Update: "+i1);
		System.out.println("Enter Account id to Delete");
		int idd=sc.nextInt();
		PreparedStatement p1=con.prepareStatement("delete from account where aid=?");
		p1.setInt(1,idd);
		int a=p1.executeUpdate();
		System.out.println(a);
		
//		System.out.println("Enter Mobile No.");
//		long mb=sc.nextLong();
//		System.out.println("Enter Account Holder Name");
//		String ah=sc.next();
//		System.out.println("Enter Initial Balance");
//		double bal=sc.nextDouble();
//		String sqlquery="insert into account values(?,?,?,?)";
//		PreparedStatement st=con.prepareStatement(sqlquery);
//		st.setInt(1,id);
//		st.setLong(2,mb);
//		st.setString(3,ah);
//		st.setDouble(4,bal);
//		int insertedRec=st.executeUpdate();
//		System.out.println("Inserted Record"+insertedRec);
		if(i1==2) {
//		System.out.println(rs1.getDouble("balance"));
//		System.out.println(rs2.getDouble("balance"));
		con.commit();}
	} catch (SQLException e) {
		con.rollback();
		System.out.println(e.getMessage()+""+e.getErrorCode()+""+e.getSQLState());
		e.printStackTrace();
	}
	finally {
		if(con!=null)
		{System.out.println("Closing Connection");
		con.close();}
	}

}
}
