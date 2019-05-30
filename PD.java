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
	
	
