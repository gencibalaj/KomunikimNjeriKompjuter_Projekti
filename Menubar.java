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
	
