package projektiKNK;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Guidelines {

	private int gid;
	private int did;
	private int pid;
	private String gdescription;
	
	public Guidelines(int gid,int did,int pid,String gdescription)
	{
		this.gid=gid;
		this.did=did;
		this.pid=pid;
		this.gdescription=gdescription;
	}
	
	public void setGid(int gid)
	{
		this.gid=gid;
		
	}
	public void setDid(int did)
	{
		this.did=did;
	}
	
	public void setPid(int pid)
	{
		this.pid=pid;
	}
