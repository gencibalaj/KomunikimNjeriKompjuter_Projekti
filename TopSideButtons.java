package projektiKNK;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class TopSideButtons extends HBox{
	private static Button AddPacient=new Button("Add Pacient");
	private static Button ShowPacients=new Button("Show Pacients");
	public static Button AddVisit=new Button("Add Visit");
	private static Button ShowVisit=new Button("Show Visits");
	public static  Button PrintGuidance=new Button("Print Guidance");
	
	public static  TextField searchBar = new TextField();	
	public static TextField searchBarVisit = new TextField();	
	
	String cssLayout = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 0;\n"+
            "-fx-font-size: 40px;-fx-background-color: linear-gradient( #f4f5f5, #dfdddd);\n"
            + "-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" 
            ;
	
	String cssButtom = "-fx-background-color: linear-gradient(to left, #f4f5f5, #dfdddd);"
			+"-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" ;
	public TopSideButtons()
	{		//
	//	getStylesheets().add(getClass().getResource("file:///C:/Users/ditjo/Desktop/leftButtons.css").toExternalForm());
			getStylesheets().add("projektiKNK/addPacient.css");
			ToggleButtons(true);
			setStyle(cssLayout);
			setAlignment(Pos.CENTER);
			setSpacing(25);
	