package projektiKNK;

import java.util.Locale;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class ToolBarRight extends ToolBar{
	private Button alButton = new Button();
	private Button enButton = new Button();
	private Button exitButton = new Button();
	private Button logoutButton = new Button();
	private static ToolBarRight rightToolbar;
	public ToolBarRight() {	
		rightToolbar = this;
		Button[] b = {alButton,enButton,null,exitButton,logoutButton};
		String[] buttons = {"al","en","s","exit","logout"}; //ID
		String[] buttonsInfo = {"Set Language to albanian","Set Language to english","","Close Program","Logout"};
		
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
	
	public static ToolBarRight getInstance() {
		return rightToolbar;
	}
	
	public void switchLanguage(String language) {
		I18N.setLocale(new Locale(language));
		
		 if(language.contentEquals("en")) {
			 enButton.setDisable(true); 
			 alButton.setDisable(false);
		 }else {
			 enButton.setDisable(false); 
			 alButton.setDisable(true);
		 }	
	}
}
