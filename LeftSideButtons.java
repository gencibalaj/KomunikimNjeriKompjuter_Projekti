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
	
