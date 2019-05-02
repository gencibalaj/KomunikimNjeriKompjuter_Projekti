package projektiKNK;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class Visit {

	private int vid;
	private int pid ;
	private int did;
	private LocalDate vdate;
	private String fname;
	private String lname;
	private String dname;
	private String description;
	
	public Visit(int vid,int pid,int did, LocalDate vdate,String fname,String lname,String description,String dname)
	{
		this.vid=vid;
		this.pid=pid;
		this.did=did;
		this.vdate=vdate;
		this.fname=fname;
		this.lname=lname;
		this.description=description;
		this.dname = dname;
	}
	
	public void setPid(int pid)
	{
		this.pid=pid;
	}
	
	public void setDid(int did)
	{
		this.did=did;
	}
	
	public void setVdate(LocalDate vdate)
	{
		this.vdate=vdate;
	}
	
	public void setFname(String fname)
	{
		this.fname=fname;
	}
	
	public void setLname(String lname)
	{
		this.lname=lname;
	}
	
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	//getters
	
	public int getPid()
	{
		return pid;
	}
	public int getVid()
	{
		return vid;
	}
	public int getDid()
	{
		return did;
	}
	
	public String getDname()
	{
		return dname;
	}
	
	
	public LocalDate getVdate()
	{
		return vdate;
	}
	
	public String getFname()
	{
		return fname;
	}
	
	public String getLname()
	{
		return lname;
	}
	public String  getDescription()
	{
		return description;
	}
	
	
	public static boolean insertInTable(int pid, int did, LocalDate vdate,String fname, String lname,String description )
	{
		String query="INSERT INTO visit(vdate,fname,lname,description,pid,did) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement =(PreparedStatement) ConnectToDB.connection.prepareStatement(query);
			preparedStatement.setString(2, fname);
			preparedStatement.setString(3, lname);
			preparedStatement.setDate(1,  Date.valueOf(vdate));
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, pid);
			preparedStatement.setInt(6, did);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	public static boolean updateInTable(int vid,String fname, String lname,LocalDate vdate,String description)
	{
		String query = "UPDATE visit SET fname=?, lname=?, vdate=? ,description=? WHERE vid=?";
		try {
			
			PreparedStatement preparedStatement =(PreparedStatement) ConnectToDB.connection.prepareStatement(query);
		

		
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setDate(3,Date.valueOf(vdate));
			preparedStatement.setString (4, description);
			preparedStatement.setInt(5, vid);
			
			System.out.println(preparedStatement.toString());
		
			
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	public static boolean deleteVisit(int vid) {
		String query = "Delete from visit where vid=?";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) ConnectToDB.connection.prepareStatement(query);
			preparedStatement.setInt(1, vid);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	}	
	


