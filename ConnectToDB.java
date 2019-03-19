package projektiKNK;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class ConnectToDB  {

	final static String username="root";
	final static  String password="diti";
	final static  String databasename="JavaProject";
	final static  String servername="localhost";
	final static  String port="3306";
	
	static Connection connection;
	
	protected	List<String> result = new ArrayList<String>();
	protected	List<String> result1 = new ArrayList<String>();
	protected 	List<String> result2 = new ArrayList<String>();
	protected	ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();  
	
	
	public   ConnectToDB() 
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		
		connection=DriverManager.getConnection
				("jdbc:mysql://"+servername+":"+port+"/"+databasename,username, password);
		
		}catch(ClassNotFoundException | SQLException e){
		    System.out.println("Exception " + e);
		   }
	
	}
	
	
	
	



	

	

	
}


	
	
	
