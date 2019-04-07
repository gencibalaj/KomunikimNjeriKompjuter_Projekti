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
