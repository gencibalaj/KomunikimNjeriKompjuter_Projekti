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
	private String ldname;
	
	public Visit(int vid,int did,int pid, LocalDate vdate,String fname,String lname,String dname, String ldname,String description)
	{
		this.vid=vid;
		this.pid=pid;
		this.did=did;
		this.vdate=vdate;
		this.fname=fname;
		this.lname=lname;
		this.description=description;
		this.dname = dname;
		this.ldname = ldname;
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
	
	public String getLdname()
	{
		return ldname;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	
	public static boolean insertInTable(int pid, int did, LocalDate vdate ,String description )
	{
		String query="INSERT INTO visit(vdate,description,pid,did) values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement =(PreparedStatement) ConnectToDB.getConnection().prepareStatement(query);
			preparedStatement.setDate(1,  Date.valueOf(vdate));
			preparedStatement.setString(2, description);
			preparedStatement.setInt(3, pid);
			preparedStatement.setInt(4, did);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	public static boolean updateInTable(int vid, LocalDate vdate,String description)
	{
		String query = "UPDATE visit SET vdate=? ,description=? WHERE vid=?";
		try {
			
			PreparedStatement preparedStatement =(PreparedStatement) ConnectToDB.getConnection().prepareStatement(query);
		
			preparedStatement.setDate(1,Date.valueOf(vdate));
			preparedStatement.setString (2, description);
			preparedStatement.setInt(3, vid);
			
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
			PreparedStatement preparedStatement = (PreparedStatement) ConnectToDB.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, vid);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static List<Visit> getVisit()
	{
		String query="SELECT v.vid, v.did, v.pid, v.vdate, p.fname, p.lname, d.dname, d.ldname, v.description FROM visit v, pacient p, doctor d WHERE v.pid = p.pid AND d.did = v.did;";
		List<Visit> visitList=new ArrayList<Visit>();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) ConnectToDB.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Visit visit = new Visit(resultSet.getInt("vid"),resultSet.getInt("did"),resultSet.getInt("pid"),LocalDate.now(),
						resultSet.getString("fname"),resultSet.getString("lname"),
						resultSet.getString("dname"),resultSet.getString("ldname"),resultSet.getString("description"));
				
				//int vid,int pid,int did, LocalDate vdate,String fname,String lname,String description,String dname
				visitList.add(visit);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return visitList;
		
	}	
	public static List<Visit> getVisitbyName(String Name)
	{
		Name="%"+Name+"%";
		String query="select * from visit where fname like"+"\""+Name+"\"";
		System.out.println(Name);
		List<Visit> visitList=new ArrayList<Visit>();
		try {
			
			PreparedStatement preparedStatement = (PreparedStatement) ConnectToDB.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				/*Visit visit = new Visit(resultSet.getInt("vid"),resultSet.getInt("pid"),resultSet.getInt("did"),resultSet.getDate("vdate").toLocalDate(),
						resultSet.getString("fname"),resultSet.getString("lname"),
						resultSet.getString("description"));
				visitList.add(visit);*/
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return visitList;
	}
	
	}
	
	


