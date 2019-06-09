package projektiKNK;

import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class Toolbar extends ToolBar {
	
	private Button addButton = new Button();
	private Button deleteButton = new Button();
	private Button updateButton = new Button();
	private Button showPacients = new Button();
	private Button showVisits = new Button();

	public Toolbar() {	
	
		Button[] b = {addButton,deleteButton,updateButton,showPacients,null,showVisits};
		String[] buttons = {"add","remove","update","showPatient","s","addVisits"}; //ID
		String[] buttonsInfo = {"Add Pacient","Show Visits","Show Visits","Show Visits","s","Add Visit"};
		
		for(int i = 0; i < buttons.length; i++) {
			
			if(buttons[i].contentEquals("s")) {
				Separator separator = new Separator(Orientation.VERTICAL);
				getItems().add(separator);
			}else {
				System.out.println("EEEEEEEE");
			 ImageView Icon = new ImageView("images/"+buttons[i]+".png");
			 Icon.setFitHeight(35);
			 Icon.setFitWidth(35);
			 b[i].setId(buttons[i]);
			 b[i].setGraphic(Icon);
			 b[i].setTooltip(new Tooltip(buttonsInfo[i]));
			 b[i].setOnAction(new AddEventsToButtons(buttons[i]));
			 getItems().add(b[i]);
			} 	 
		}
	}
	
	public void ToggleButtons(Boolean toggle) {
		deleteButton.setDisable(toggle);
		updateButton.setDisable(toggle);
		showVisits.setDisable(toggle);
	}
}
