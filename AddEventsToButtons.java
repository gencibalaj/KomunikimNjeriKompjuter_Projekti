
package projektiKNK;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddEventsToButtons implements  EventHandler<ActionEvent>  {
	private String id;
	
	public AddEventsToButtons(String id) {
		this.id = id;
	}
	

	@Override
	public void handle(ActionEvent event) {
		switch(id) {
			case "add":
				MainProgram.primaryPane.setCenter(new AddPacient());
				break;
			case "remove":
				//TODO
				Pacient.deletePacient(MainProgram.getPacient().getPid());
				break;
			case "addVisits":
				MainProgram.primaryPane.setCenter(new AddVisit());
				break;
			case "update":
				MainProgram.primaryPane.setCenter(new AddPacient(MainProgram.getPacient()));
				break;
			case "showPatient":
				MainProgram.primaryPane.setCenter(new ShowPacients());
				break;
			case "al":
				((Button)topPart.getToolbar().lookup("#al")).setDisable(true);
				((Button)topPart.getToolbar().lookup("#en")).setDisable(false);
				Toolbar.switchLanguage("al");
				break;
			case "en":
				((Button)topPart.getToolbar().lookup("#al")).setDisable(false);
				((Button)topPart.getToolbar().lookup("#en")).setDisable(true);
				Toolbar.switchLanguage("en");
				break;
		}
	}
	
}
