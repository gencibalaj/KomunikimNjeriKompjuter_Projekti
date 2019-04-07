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
	