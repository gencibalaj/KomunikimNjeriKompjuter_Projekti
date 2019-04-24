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
			}else {
			 ImageView Icon = new ImageView("images/"+buttons[i]+".png");
			 Icon.setFitHeight(30);
			 Icon.setFitWidth(30);
			 Button b = new Button();
			 b.setGraphic(Icon);
			 b.setId(buttons[i]);
			 b.setTooltip(new Tooltip(buttonsInfo[i]));
			 b.setOnAction(new AddEventsToButtons(buttons[i]));
			 getItems().add(b);
			} 
			 
		}
	}
	public static void switchLanguage(String language) {
		I18N.setLocale(new Locale(language));
		/*
		 * ((Button)this.lookup("#"+language)).setDisable(true);
		 * if(language.contentEquals("en")) {
		 * ((Button)this.lookup("#al")).setDisable(false); }else {
		 * ((Button)this.lookup("#en")).setDisable(false); }
		 */
		
	}
	
	
}



