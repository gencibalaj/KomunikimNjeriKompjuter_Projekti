package projektiKNK;

import java.sql.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.AlignmentAction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShowVisits extends VBox {
	String cssLayout = 
            "-fx-font-size: 20px;\n"+
            "-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" ;
	Button Delete=new Button("Delete");
	Button Update=new Button("Update");
	public static HBox h=new HBox(10);
	

	
	private TableColumn<Visit,Integer> column1 = new TableColumn<>("VID");	
	private TableColumn<Visit,Integer> column2 = new TableColumn<>("PID");
	private TableColumn<Visit,Integer> column3 = new TableColumn<>("DID");
	private TableColumn<Visit,Date> column4 = new TableColumn<>("Date");
	private TableColumn<Visit,String> column5 = new TableColumn<>("Name");
	private TableColumn<Visit,String> column6 = new TableColumn<>("Last Name");
	private TableColumn<Visit,String> column7 = new TableColumn<>("Description");
	private TableColumn<Visit,String> column8 = new TableColumn<>("Description");
	
	
	public ShowVisits()
	{
		super(20);
		setStyle("-fx-background-color:pink;");
		TableView<Visit> table1 = new TableView<>();
		getStylesheets().add("projektiKNK/style.css");
		HBox buttons = new HBox(10);
		Button Delete=new Button("Delete");
		Button Update=new Button("Update");
		buttons.getChildren().addAll(Delete,Update);
		
		table1.prefHeightProperty().bind(this.heightProperty());
		table1.setStyle(cssLayout);
		getChildren().addAll(buttons,table1);
		
		table1.setEditable(true);
		
		column1.setCellValueFactory(new PropertyValueFactory("vid"));
		column1.setPrefWidth(100);
		
		column2.setCellValueFactory(new PropertyValueFactory("pid"));
		column2.setPrefWidth(100);
		
		column3.setCellValueFactory(new PropertyValueFactory("did"));
		column3.setPrefWidth(100);
		
		column4.setCellValueFactory(new PropertyValueFactory("vdate"));
		column4.setPrefWidth(100);
		
		
			
	
				
