package com.dao;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.sql.Statement;

public class MavenJdbc {
	Connection con;
	PreparedStatement ps;
	int i;
	public Connection myConnection(){
		//1.load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","Newuser123");
			System.out.println("Connection to db..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch connection..");
		} catch (SQLException e) {
			System.out.println("catch connection..2");
			e.printStackTrace();
		}
		return con;
	}
	public int saveData(String fname,String lname,String city,String phone){
		try {
			con=myConnection();
			ps=con.prepareStatement("insert into maven1(fname,lname,city,phone) values(?,?,?,?)");
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,city);
			ps.setString(4,phone);
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("test11");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("global.."+e);
		}
		return i;
	}
/*	public int deleteRecord(int no){
		try {
			con=myConnection();
			ps=con.prepareStatement("delete from employee where empno=?");
			ps.setInt(1,no);
			i=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public void searchRecord(int empno){
		try {
			con=myConnection();
			ps=con.prepareStatement
					("select empno,ename,salary from employee where empno=?");
			ps.setInt(1,empno);;
			ResultSet rs=ps.executeQuery();
			rs.next();
			System.out.println
			(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayAll(){
		String str="select empno, ename, salary from employee";
		try {
			con=myConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(str);

			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println("\n--------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void storePro(int id) {
		try {
			con=myConnection();
			CallableStatement stmt=con.prepareCall("{call emp_proc(?)}");  
			stmt.setInt(1,id);  
			stmt.execute();
			System.out.println("success");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
	
		
	}*/
}


