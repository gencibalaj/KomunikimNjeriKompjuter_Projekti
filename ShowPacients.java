package projektiKNK;

import java.sql.Date;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShowPacients extends VBox{

	String cssLayout = 
            "-fx-font-size: 20px;\n"+
            "-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" ;
	private TableColumn<Pacient,String> 	column1 = new TableColumn<>("First Name");	
	private TableColumn<Pacient,String>	column2 = new TableColumn<>("Last Name");	
	private TableColumn<Pacient,Date> 	column3 = new TableColumn<>("Birthday");	
	private TableColumn<Pacient,Boolean> column4 = new TableColumn<>("Gender");	
	private TableColumn<Pacient,String> 	column5 = new TableColumn<>("RHFactory");	
	private TableColumn<Pacient,String> 	column6 = new TableColumn<>("Blood Type");	
	private TableColumn<Pacient,String> 	column7 = new TableColumn<>("Place");	
	private TableColumn<Pacient,String> 	column8 = new TableColumn<>("Vaccinations");	
	private TableColumn<Pacient,String> 	column9 = new TableColumn<>("Allergiers");	
	private TableColumn<Pacient,String> 	column10 = new TableColumn<>("Personal NR");	
	ScrollPane s=new ScrollPane();

	TableView<Pacient> table = new TableView<>();
	public ShowPacients()
	{
		super(20);
		setStyle("-fx-background-color:pink;");
		
		HBox buttons = new HBox(10);
		Button Delete=new Button("Delete");
		Button Update=new Button("Update");
		buttons.getChildren().addAll(Delete,Update);
		
		table.prefHeightProperty().bind(this.heightProperty());
		table.setStyle(cssLayout);
		getChildren().addAll(buttons,table);
		
		table.setEditable(true);
		
		column1.setCellValueFactory(new PropertyValueFactory("fname"));
		column1.setPrefWidth(100);
	