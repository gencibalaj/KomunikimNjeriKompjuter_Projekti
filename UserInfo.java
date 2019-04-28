package projektiKNK;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class UserInfo extends GridPane{
	
	private Label name=new Label("User Name");
	private Label lname=new Label("User Last Name");
	private Text namefromdb=new Text();
	private Text lnamefromdb=new Text();
	
	public UserInfo(String Name, String Lname)
	{
		setAlignment(Pos.CENTER);
		namefromdb.setText(Name);
		lnamefromdb.setText(Lname);
		setVgap(10);
		setHgap(10);
		addRow(0,name,namefromdb);
		addRow(1,lname,lnamefromdb);
		
	}
}
