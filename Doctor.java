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
