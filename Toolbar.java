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
	
	Button addButton;
	Button deleteButton;

	public Toolbar() {	
		String[] buttons = {"add","remove","update","showPatient","s","addVisits","al","en"};
		String[] buttonsInfo = {"Add Pacient","Show Visits","Show Visits","Show Visits","s","Add Visit","Set Language to albanian","Set Language to english"};
		
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].contentEquals("s")) {
				Separator separator = new Separator(Orientation.VERTICAL);
				getItems().add(separator);
