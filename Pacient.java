package projektiKNK;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pacient {
	//instance
	private int pid; 
	private String fname;
	private String lname ;
	private LocalDate bday;
	private Boolean gender;
	private String rhfactory;
	private String bloodtype ;
	private String place ;
	private String vaccinations;
	private String allergiers;
	private String personalnr;
	private ObjectProperty<Pacient> Property;
	
	public Pacient(int pid,String fname, String lname,LocalDate bday,String place,Boolean gender,
			String rhfactory,String bloodtype,String  vaccinations,String allergiers,String personalnr)
	{
		this.pid=pid;	
		this.fname=fname;
		this.lname=lname;
		this.bday=bday;
		this.gender=gender;
		this.rhfactory=rhfactory;
		this.bloodtype=bloodtype;
		this.place=place;
		this.vaccinations=vaccinations;
		this.allergiers=allergiers;
		this.personalnr=personalnr;
	}

	public int getPid()
	{
		return this.pid;
	}
	
	public String getFname()
	{
		return this.fname;
	}
	public String getLname()
	{
		return this.lname;
	}
	
	public LocalDate getBday()
	{
		return this.bday;
	}
	
	public Boolean getGender()
	{
		return this.gender;
	}
	
	public String getRhfactory()
	{
		return this.rhfactory;
	}
	
	public String getBloodtype()
	{
		return this.bloodtype;
	}
	
	public String getPlace()
	{
		return this.place;
	}
	public String getVaccinations()
	{
		return this.vaccinations;
	}
	public String getAllergiers()
	{
		return this.allergiers;
	}
	public String getPersonalnr()
	{
		return this.personalnr;
	}
	
	//seters
	public void setAllergiers(String allergiers)
	{
		this.allergiers=allergiers;
	}
	
	public void setPersonalnr(String personalnr)
	{
		this.personalnr=personalnr;
	}
	
	
	public void setGender(Boolean gender)
	{
		this.gender=gender;
	}
	
	public void setRHfactory(String rhfactory)
	{
		this.rhfactory=rhfactory;
	}
	
	public void setVaccinations(String vaccinations)
	{
		this.vaccinations=vaccinations;
	}
	
	public void setBloodType(String bloodtype)
	{
		this.bloodtype=bloodtype;
	}
	public void getPlace(String place)
	{
		this.place=place;
	}
	
	public void setPid(int pid)
	{
		this.pid=pid;
		
	}
	
	public void setFname(String fname)
	{
		this.fname=fname;
	}
	
	public void setLname(String lname)
	{
		this.lname=lname;
	}
	public void setBday(LocalDate bday)
	{
		this.bday=bday;
	}
	
	public static boolean insertInPacient(String fname, String lname,LocalDate date,String place,Boolean gender,
			String rhfactory,String bloodtype,String  vaccinations,String allergiers,String personalnr)
	{
		String query = "INSERT INTO pacient(fname, lname, bday,place,gender,rhfactory,bloodtype,vaccinations,allergies,personalnr) VALUES(?,?,?,?,?,?,?,?,?,?)";
		System.out.println(query);
		try {
			
			PreparedStatement preparedStatement =(PreparedStatement) ConnectToDB.connection.prepareStatement(query);
		

		
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setDate(3,  Date.valueOf(date));
			preparedStatement.setString(4, place);
			preparedStatement.setBoolean(5,gender);
			preparedStatement.setString(6, rhfactory);
			preparedStatement.setString(7, bloodtype);
			preparedStatement.setString(8, vaccinations);
			preparedStatement.setString(9, allergiers);
			preparedStatement.setString(10, personalnr);
		
	
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
		public static boolean updateInPacient(int pid,String fname, String lname,LocalDate bday,String place,Boolean gender,
				String rhfactory,String bloodtype,String  vaccinations,String allergies,String personalnr)
		{
			String query = "UPDATE pacient SET fname=?, lname=?, bday=?,place=?,gender=?,rhfactory=?,bloodtype=?,vaccinations=?, allergies=?, personalnr=? WHERE pid=?";
			try {
				
				PreparedStatement preparedStatement =(PreparedStatement) ConnectToDB.connection.prepareStatement(query);
			

			
				preparedStatement.setString(1, fname);
				preparedStatement.setString(2, lname);
				preparedStatement.setDate(3, Date.valueOf(bday));
				preparedStatement.setString(4, place);
				preparedStatement.setBoolean(5,gender);
				preparedStatement.setString(6, rhfactory);
				preparedStatement.setString(7, bloodtype);
				preparedStatement.setString(8, vaccinations);
				preparedStatement.setString(9, allergies);
				preparedStatement.setString(10, personalnr);
				preparedStatement.setInt(11, pid);
				
			
				
				
				return (preparedStatement.executeUpdate() > 0);
			} catch(SQLException ex) {
				ex.printStackTrace();
				return false;	
			}
			
		
	}
		public static boolean deletePacient(int pid) {
			String query = "Delete from pacient where pid=?";
			
			try {
				PreparedStatement preparedStatement = (PreparedStatement) ConnectToDB.connection.prepareStatement(query);
				preparedStatement.setInt(1, pid);
				return (preparedStatement.executeUpdate() > 0);
			} catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		
		public static ObservableList<Pacient> getPacient()
		{
			String query="SELECT * FROM pacient";
			ObservableList<Pacient> pacientList= FXCollections.observableArrayList();
			try {
				PreparedStatement preparedStatement = (PreparedStatement) ConnectToDB.connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Pacient pacient = new Pacient(resultSet.getInt("pid"),resultSet.getString("fname"),resultSet.getString("lname"),resultSet.getDate("bday").toLocalDate(),
							resultSet.getString("place"),resultSet.getBoolean("gender"),resultSet.getString("rhfactory"),resultSet.getString("bloodtype")
							,resultSet.getString("vaccinations"),resultSet.getString("allergies"),resultSet.getString("personalnr"));
					pacientList.add(pacient);
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			
			return pacientList;
			
		}	
		public static ObservableList<Pacient> getPacientByName(String Name)
		{
			Name="%"+Name+"%";
			String query="select * from pacient where fname like"+"\""+Name+"\"";
			ObservableList<Pacient> pacientList= FXCollections.observableArrayList();
			try {
				PreparedStatement preparedStatement = (PreparedStatement) ConnectToDB.connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Pacient pacient = new Pacient(resultSet.getInt("pid"),resultSet.getString("fname"),resultSet.getString("lname"),resultSet.getDate("bday").toLocalDate(),
							resultSet.getString("place"),resultSet.getBoolean("gender"),resultSet.getString("rhfactory"),resultSet.getString("bloodtype")
							,resultSet.getString("vaccinations"),resultSet.getString("allergies"),resultSet.getString("personalnr"));
					pacientList.add(pacient);
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			
			return pacientList;
			
		}	
}
