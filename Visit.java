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
	
	