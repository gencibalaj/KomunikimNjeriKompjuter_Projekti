package projektiKNK;


import java.text.ParseException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Login extends Application
{
	public void start(Stage primaryStage)
	{
		VBox vb=new VBox(10);
		vb.setPadding(new Insets(15, 5, 5, 5));
		vb.setAlignment(Pos.CENTER);
		
		GridPane pane =new GridPane();
		//pane.setGridLinesVisible(true);
		String CssTextField=("-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);");
		String CssTextField1=("-fx-opacity:0.9;"
				+ "");
		//fotot
		Image image = new Image("images/ordi2.png");
		ImageView img=new ImageView();
		img.setImage(image);
		img.setFitHeight(250);	
		img.setFitWidth(250);
		img.setStyle(CssTextField);
		
		
		//labels
		Label EmriPerdorues =new Label("Emriperdorues");
		Label Fjalekalmi = new Label("Fjalekalimi");
		
		//textfields
		
		TextField PerEmerPerdorues=new TextField();
		TextField PerFjalkalimi=new TextField();
		PerEmerPerdorues.setStyle(CssTextField);
		PerFjalkalimi.setStyle(CssTextField);
		EmriPerdorues.setStyle(CssTextField1+CssTextField);
		Fjalekalmi.setStyle(CssTextField1+CssTextField);
		Text text = new Text("Gbim");
		text.setVisible(false);
		EmriPerdorues.setFont(Font.font ("Arial ", 15));
		Fjalekalmi.setFont(Font.font ("Arial ", 15));
		
		
		//butonat
		Button login=new Button("Kyçu");
		login.setStyle("-fx-background-color:lightblue;"+"-fx-effect: dropshadow(gaussian,grey,1,1,1,1);"+"-fx-opacity:0.9");
		login.setFont(Font.font ("Arial Black", 13));
		
		login.setOnAction(e -> {
				new ConnectToDB();
				Doctor doctor = Doctor.login(PerEmerPerdorues.getText() , PerFjalkalimi.getText());
				if(doctor != null) {
					Stage stage = new Stage();
					new MainProgram(stage,doctor);
					primaryStage.close();
				}else {
					text.setVisible(true);
				}
		});
		
			
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		
	
		pane.add(EmriPerdorues, 0, 0);
		pane.add(PerEmerPerdorues, 1, 0);
		pane.add(Fjalekalmi, 0, 2);
		pane.add(PerFjalkalimi,1,2 );
		pane.add(text, 2, 3);
		
		pane.setHalignment(login, HPos.RIGHT);
