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
