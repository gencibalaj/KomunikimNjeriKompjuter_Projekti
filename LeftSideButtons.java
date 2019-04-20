package projektiKNK;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class LeftSideButtons extends VBox{
	private static Button AddPacient=new Button();
	private static Button ShowPacients=new Button();
	public static Button AddVisit=new Button();
	private static Button ShowVisit=new Button();
	public static  Button PrintGuidance=new Button();
	
	public static  TextField searchBar = new TextField();	
	public static TextField searchBarVisit = new TextField();	
	
	String cssLayout = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 0;\n"+
            "-fx-font-size: 22px;-fx-background-color: linear-gradient( #f4f5f5, #dfdddd);\n"
            + "-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" 
            ;
	
	String cssButtom = "-fx-background-color: linear-gradient(to left, #f4f5f5, #dfdddd);"
			+"-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" ;
	public LeftSideButtons()
	{		//
		
	//	getStylesheets().add(getClass().getResource("file:///C:/Users/ditjo/Desktop/leftButtons.css").toExternalForm());
			getStylesheets().add("projektiKNK/addPacient.css");
			ToggleButtons(true);
			setStyle(cssLayout);
			setAlignment(Pos.CENTER);
			setSpacing(25);
			StackPane sp=new StackPane();
			sp.setPrefWidth(220);
			sp.setPadding(new Insets(5,5,5,5));
			sp.getChildren().add(new ClockPane());
			searchBar.setId("searchBar");
			searchBar.setPromptText("Search Pacient");
			searchBarVisit.setPromptText("Search Visit");
			searchBarVisit.setId("searchBarVisir");
			getChildren().addAll(sp,searchBarVisit,searchBar,AddPacient,ShowPacients,ShowVisit,AddVisit,PrintGuidance);
			
			this.setPrefWidth(220);
			AddPacient.setStyle(cssButtom);
			ShowPacients.setStyle(cssButtom);
