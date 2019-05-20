package projektiKNK;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MenuBar extends HBox {
		
	private Text File=new Text(50,50,"File");
	private Text Edit=new Text("Edit");
	private Text Help=new Text("Help");
	private Text Account=new Text("Account");
	
	
	
	
	public MenuBar()
	{
		setSpacing(25);
	
		getChildren().addAll(File,Edit,Help,Account);
	}
	
	
}
a