package studentCRUDOperation;
import java.sql.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String dbURL="jdbc:mysql://localhost:3306/studentdb";
	String username="root";
	String password="Aditi@1615";
	
	DBConnection(){
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, username, password);
			 
			System.out.println("Connection Established");
			
		}catch(Exception e) {}
	}
	public void insert(int sno, String sname, int dob, int doj)throws Exception{
		ps = con.prepareStatement("INSERT INTO student (STUDENT_NO,STUDENT_NAME,STUDENT_DOB,STUDENT_DOJ) VALUES(?,?,?,?)");
		ps.setInt(1,sno);
		ps.setString(2,sname);
		ps.setInt(3,dob);
		ps.setInt(4,doj);
		ps.executeUpdate();
	}
	public void update(int sno, String sname, int dob, int doj)throws Exception{
		ps = con.prepareStatement("UPDATE student SET STUDENT_NAME = ?, STUDENT_DOB = ?, STUDENT_DOJ = ? WHERE STUDENT_NO = ?");
		ps.setInt(4,sno);
		ps.setString(1,sname);
		ps.setInt(2,dob);
		ps.setInt(3,doj);
		ps.executeUpdate();
	}
	public void delete(int sno)throws Exception{
		ps = con.prepareStatement("SELECT * FROM student WHERE STUDENT_NO = ?");
		ps.setInt(1,sno);
		rs = ps.executeQuery();
		if(rs.next()) {
			ps = con.prepareStatement("DELETE FROM student WHERE STUDENT_NO = ?");
			ps.setInt(1,sno);
			ps.executeUpdate();
		}
		else {
			System.out.println("Record Not Found");
		}
	}
	public void display() throws Exception{
		ps = con.prepareStatement("SELECT * FROM student");
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.printf("%-15s%-20s%15s%15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}
	}
	public void search(int sno) throws Exception{
		ps = con.prepareStatement("SELECT * FROM student WHERE STUDENT_NO = ?");
		ps.setInt(1,sno);
		rs = ps.executeQuery();
		if(rs.next()) {
			System.out.printf("%-15s%-20s%15s%15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}
		else
			System.out.println("Record Not Found.....!");
		
	}
	public void close() throws Exception{
		con.close();
		System.out.println("Connection closed");
	}

}
