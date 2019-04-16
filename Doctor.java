package projektiKNK;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class Doctor {
	private int id;
	private String dname;
	private String ldname;
	private String email;
	private String password;
	
	public Doctor(int id,String dname, String ldname,String email,String password) {
		this.id = id;
		this.dname = dname;
		this.ldname = ldname;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDname() {
		return dname;
	}
	
	public String getLdname() {
		return ldname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String dname) {
		this.dname = dname;
	}
	
	public void setLdname(String ldname) {
		this.ldname = ldname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static boolean addDoctor(String dname, String ldname, String email, String password) {
		String query = "INSERT INTO doctor(dname, ldname, email, password) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, dname);
			preparedStatement.setString(2, ldname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
	public static boolean deleteDoctor(int did) {
		String query = "DELETE FROM doctor WHERE did=?";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, did);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateDoctor(int did,String dname, String ldname, String email, String password) {
		String query = "UPDATE doctor SET dname=?, ldname=?, email=?, password=? WHERE did=?";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, dname);
			preparedStatement.setString(2, ldname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, did);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
