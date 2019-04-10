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
		getStylesheets().add("projektiKNK/style.css");
		
		column2.setCellValueFactory(new PropertyValueFactory("lname"));
		column2.setPrefWidth(100);
		
		
		column3.setCellValueFactory(new PropertyValueFactory("bday"));
		column3.setPrefWidth(100);
		
		
		column4.setCellValueFactory(new PropertyValueFactory("gender"));
		column4.setPrefWidth(100);
		
		column5.setCellValueFactory(new PropertyValueFactory("rhfactory"));
		column5.setPrefWidth(150);
		
		
		column6.setCellValueFactory(new PropertyValueFactory("bloodtype"));
		column6.setPrefWidth(150);
		
		
		column7.setCellValueFactory(new PropertyValueFactory("place"));
		column7.setPrefWidth(100);
	
		
		column8.setCellValueFactory(new PropertyValueFactory("vaccinations"));
		column8.setPrefWidth(150);
		
		
		column9.setCellValueFactory(new PropertyValueFactory("allergiers"));
		column9.setPrefWidth(150);
		
		
		column10.setCellValueFactory(new PropertyValueFactory("personalnr"));
		column10.setPrefWidth(150);
		
		
		setPadding(new Insets(10,10,10,10));
		
		 //setMaxWidth(1020);
		 //setMinHeight(10000);
		 
		
		
		table.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8,column9,column10);
		
		
	table.getItems().addAll(Pacient.getPacientByName(LeftSideButtons.searchBar.getText()));
		/*table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	LeftSideButtons.AddVisit.setDisable(false);
		    }
		    else
		    {
		    	LeftSideButtons.AddVisit.setDisable(true);
		    }
		});
		*/
		
		
		
		Delete.setOnAction(e -> {
			System.out.println("Eltio");
			Pacient p = table.getSelectionModel().getSelectedItem();
			if(p != null) {
				
				Pacient.deletePacient(p.getPid());
				table.getItems().clear();
				table.getItems().addAll(Pacient.getPacient());
			}
		});
		
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pacient>() {

			@Override
			public void changed(ObservableValue observable, Pacient oldValue, Pacient newValue) {
				Pacient p = table.getSelectionModel().getSelectedItem();
				if(p != null) {
					
				}
			}
			
		});
	
