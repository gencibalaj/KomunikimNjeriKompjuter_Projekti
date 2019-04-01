package projektiKNK;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AddVisit extends GridPane{

	private TextField Fname=new TextField(); 
	private TextArea Description=new TextArea();
	private TextField LName=new TextField();
	
	private DatePicker  Vdate=new DatePicker();
	private Button Clear = new Button("Clear");

	
	private Button Update = new Button("Update");

	private Button Add = new Button("Add");
	
	
	

	