package projektiKNK;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MainProgram {

	
	
	public static BorderPane primaryPane;
	public static Stage PrintGuidance=new Stage();
	public static Scene s;
	public static Doctor doctor;
	private static Pacient pacient;
	
	
	ComboBox<String> languagesCbo = new ComboBox<>();
	
	public static Pacient getPacient() {
		return pacient;
	}
	
	public static void setPacient(Pacient p) {
		pacient = p;
		LeftSideButtons.ToggleButtons(false);
	}
	
	public MainProgram(Stage stage, Doctor doctor)  
	{
		new ConnectToDB();
		this.doctor = doctor;
		ScrollPane slide=new ScrollPane();	
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX(primaryScreenBounds.getMinX());
		stage.setY(primaryScreenBounds.getMinY());
		stage.setWidth(primaryScreenBounds.getWidth());
		stage.setHeight(primaryScreenBounds.getHeight());
		stage.setResizable(false);
		
		//TableView t=new TableView();
		primaryPane=new BorderPane();
		
			ObservableList<String> allowedLanguages = FXCollections.observableArrayList();
			
			for(int i = 0;i < I18N.getLanguages().size();i++) {
