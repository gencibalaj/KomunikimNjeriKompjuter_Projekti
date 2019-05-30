package projektiKNK;

public class PD {

		private int did;
		private int pid;
		
	public void PDSeter(String s,int v)
	{
		switch ( s)
		{
		case "pid":
			this.pid=v;
			break;
		case "did":
			this.did=v;
			break;
		}
	}
	
	public int PDgeter(String s)
	{
		int v =0;
		switch (s)
		{
		case "pid":
			v=this.pid;
			break;
		case "did":
			v=this.did;
			break;
			
		}
		return v;
		
	}
	
}
