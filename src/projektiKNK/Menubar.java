package projektiKNK;

import java.util.Collection;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menubar extends MenuBar {
		
	private static Menubar menu;
	
	 Menu File=new Menu("File");
	 Menu Edit=new Menu("Edit");
	 Menu View=new Menu("View");
	 Menu Help=new Menu("Help");
	 
	
	
	 MenuItem exit = new MenuItem("Exit");
	 
	 
	 
	 MenuItem LogOut = new MenuItem("Log Out");
	 MenuItem AddPatient = new MenuItem("Add New Patient");
	 MenuItem ShowPatient = new MenuItem("Show Patients");
	 MenuItem Delete = new MenuItem("Delete Patient");
	 MenuItem Update = new MenuItem("Update Patient");
	 MenuItem AddVisit = new MenuItem("Add Visit");
	 MenuItem ShowVisit = new MenuItem("Show Visit");
	 MenuItem nightMode=new MenuItem("Night Mode");
	 MenuItem ShowHelp=new MenuItem("Show Help");
	 MenuItem ShowVersion=new MenuItem("Show Version");
	 CheckMenuItem ShowRightToolBox = new CheckMenuItem("Show Right Toolbox");
	 CheckMenuItem ShowMainToolBox = new CheckMenuItem("Show Main Toolbox");
	 RadioMenuItem English = new RadioMenuItem("English");
	 RadioMenuItem Albanian = new RadioMenuItem("Albanian");
	 ToggleGroup language = new ToggleGroup();
	
	
	
	public Menubar()
	{
		
		menu = this;
		ShowRightToolBox.setSelected(true);
		English.setToggleGroup(language);
		Albanian.setToggleGroup(language);
		English.setSelected(true);
		ShowMainToolBox.setSelected(true);
		File.getItems().addAll(AddPatient, ShowPatient, LogOut, exit);
		Edit.getItems().addAll(Delete,Update, AddVisit, ShowVisit);
		View.getItems().addAll(ShowRightToolBox,ShowMainToolBox,English,Albanian);
		Help.getItems().addAll(ShowHelp,ShowVersion);
		getMenus().addAll(File,Edit,View,Help);
		
		exit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
		AddPatient.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		ShowPatient.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
		AddVisit.setAccelerator(new KeyCodeCombination(KeyCode.P,KeyCodeCombination.SHIFT_DOWN, KeyCombination.CONTROL_DOWN));
		Update.setAccelerator(new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN));
		ShowVisit.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.SHIFT_DOWN));
		ShowHelp.setAccelerator(new KeyCodeCombination(KeyCode.F11));
		
		
		AddPatient.setOnAction(new AddEventsToButtons("add"));
		ShowPatient.setOnAction(new AddEventsToButtons("showPatient"));
		Update.setOnAction(new AddEventsToButtons("update"));
		ShowMainToolBox.setOnAction(new AddEventsToButtons("showMainToolBox"));
		ShowRightToolBox.setOnAction(new AddEventsToButtons("showRightToolBox"));
		AddVisit.setOnAction(new AddEventsToButtons("addVisits"));
		ShowVisit.setOnAction(new AddEventsToButtons("showVisits"));
		
		English.setOnAction(new AddEventsToButtons("en"));
		Albanian.setOnAction(new AddEventsToButtons("al"));
		
		Help.setOnAction(new AddEventsToButtons("Help"));
		ShowVersion.setOnAction(new AddEventsToButtons("Version"));
		
		exit.setOnAction(new AddEventsToButtons("exit"));
		LogOut.setOnAction(new AddEventsToButtons("logout"));
		
	}
	
	public Menubar getInstance() {
		return menu;
	}
	

	
	
}
