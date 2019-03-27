package projektiKNK;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BottomPart extends VBox {
	Image image = new Image("projektiKNK/shutdown.png");
	ImageView img=new ImageView();
	Image image1 = new Image("projektiKNK/restar.png");
	ImageView img1=new ImageView();
	static Text message = new Text();
	static Label DoctorLabel = new Label();
	static Label Description = new Label();
	public BottomPart()
	{	
		
		//setSpacing(600);
		getStylesheets().add("projektiKNK/main.css");
		//setStyle("-fx-background-color: #605ca8;");
		setId("statusBar");
		setAlignment(Pos.CENTER);
		img.setImage(image);
		img.setFitHeight(200);	
		img.setFitWidth(200);
		
		img1.setImage(image1);
		img1.setFitHeight(200);	
		img1.setFitWidth(200);
		HBox hbox = new HBox();
		//hbox.getChildren().addAll(sp);
		setAlignment(Pos.CENTER);
		StackPane Messages = new StackPane();
		Messages.setVisible(false);
		Messages.setMaxWidth(this.getWidth()/2);	
		Messages.setStyle("-fx-background-color: green; -fx-background-radius: 50px;");
		Messages.setPadding(new Insets(10));
		message.setFill(Color.WHITE);
		Messages.getChildren().add(message);
		
		
		