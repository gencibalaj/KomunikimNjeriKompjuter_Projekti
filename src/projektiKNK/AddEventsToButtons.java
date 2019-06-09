
package projektiKNK;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.application.Platform;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
				Alert alert = new Alert(AlertType.CONFIRMATION,"Are you sure you want to delete current patient!",ButtonType.YES, ButtonType.CANCEL);
				alert.showAndWait();
				if (alert.getResult() == ButtonType.YES) {
					Pacient.deletePacient(MainProgram.getPacient().getPid());
				}
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
			case "showVisits":
				MainProgram.primaryPane.setCenter(new ShowVisits());
				break;
			case "al":
				ToolBarRight.getInstance().switchLanguage("al");
				break;
			case "en":
				ToolBarRight.getInstance().switchLanguage("en");
				break;
			case "showMainToolBox":
				topPart.getInstance().toggleToolbar();
				break;
			case "showRightToolBox":
				RightPart.getInstance().toggleToolbar();
				break;
			case "Help":
				Help.showHelp();
				break;
			case "Version":
				showVersion();
				break;
			case "exit":
				((Stage)MainProgram.primaryPane.getScene().getWindow()).close();
				break;
			case "logout":
				((Stage)MainProgram.primaryPane.getScene().getWindow()).close();
				new Login().start( new Stage());
				break;
			case "print":
				 Stage s=new Stage();
				 s.setScene(new Scene(new PrintGuideline()));
					s.show();
				break;
				
		}
	}
	
	void showVersion() {
		Alert alert = new Alert(AlertType.INFORMATION,"Version 1.0",ButtonType.CANCEL);
		alert.showAndWait();
	}
}
