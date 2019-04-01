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
	
	
	

	String cssLayout = 
            "-fx-font-size: 20px;\n" 
			+"-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);";
	
	public AddVisit(Visit v) {
		this();
		
		Vdate.setValue(v.getVdate());
		Fname.setText(v.getFname());
		LName.setText(v.getLname());
		Description.setText(v.getDescription());
		Update.setVisible(true);
		Add.setVisible(false);
		add(Update,5,6);
		Update.setOnAction(e->{
			if(Validate()) {
			System.out.println(Fname.getText());
			System.out.println(v.getVid());
			Visit.updateInTable(v.getVid(),Fname.getText(),LName.getText(),Vdate.getValue(),Description.getText());
			}
		});
		
	}
	
	public AddVisit()
	{
		setStyle(cssLayout);
	
		setVgap(20);
		setHgap(20);
		setAlignment(Pos.CENTER);
		addRow(0,new Label("First Name"),Fname);
		addRow(1,new Label("Last Name"),LName);
		addRow(2,new Label("Description"),Description);
		addRow(3,new Label("Visit Date"),Vdate);
		
		add(Clear,5,5);
		
	add(Add,5,6);
		
		
		Clear.setOnAction(c->{
			 clearFields();

		});
		Add.setOnAction(e -> {
			if(Validate()) {
			
			
			Visit.insertInTable(MainProgram.getPacient().getPid(),MainProgram.doctor.getId(),Vdate.getValue(),Fname.getText(), LName.getText(), Description.getText());
			}
		});
	
	}
	
	
	
	public Button getClear() {
		return this.Clear;
	}
	public  void clearFields()
	{
		Fname.setText("");
		LName.setText("");
		
		Description.setText("");
		Vdate.setValue(null);

	}
	/*public static Boolean getGender()
	{
		Boolean ok=true;
		if (gender.toLowerCase().indexOf("female".toLowerCase()) != -1)
		{
			ok=true;
		}
		else
		{
			ok=false;
		}
		return ok;
		
	}*/
	