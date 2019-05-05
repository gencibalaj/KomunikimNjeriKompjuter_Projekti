package projektiKNK;

import java.util.Collection;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menubar extends VBox {
		
	MenuBar allopsions=new MenuBar();
	 Menu File=new Menu("File");
	 Menu Edit=new Menu("Edit");
	 Menu Help=new Menu("Help");
	 Menu Account=new Menu("Account");
	
	
	 MenuItem exit = new MenuItem("Exit");
	 MenuItem restart = new MenuItem("Restart");
	 
	 MenuItem nightMode=new MenuItem("Night Mode");
	
	public Menubar()
	{
		
		File.getItems().addAll(exit, restart);
		Edit.getItems().addAll(nightMode);
		allopsions.getMenus().addAll(File,Edit,Help,Account);
		getChildren().add(allopsions);
		
		
		
		
		exit.setOnAction(e->{
			exit((Stage)(this.getScene().getWindow()));
		});
		restart.setOnAction(e->{
			exit((Stage)(this.getScene().getWindow()));
		
			 Platform.runLater( () -> new Login().start( new Stage() ) );
			
			
			
		});
		
	}
	
	public void exit(Stage s)
	{	
		s.close();
		
	}
	
	
}
