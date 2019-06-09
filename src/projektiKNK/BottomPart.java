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
	Label DoctorLabel = I18N.getLabel("Doctor",MainProgram.doctor.getDname(),MainProgram.doctor.getLdname());
	static Label PacientLabel = new Label();
	public BottomPart()
	{	
		
		getStylesheets().add("projektiKNK/main.css");
		
		setId("statusBar");
		
		setAlignment(Pos.CENTER);
		StackPane Messages = new StackPane();
		Messages.setVisible(false);
		Messages.setMaxWidth(this.getWidth()/2);	
		Messages.setStyle("-fx-background-color: green; -fx-background-radius: 50px;");
		Messages.setPadding(new Insets(10));
		message.setFill(Color.WHITE);
		Messages.getChildren().add(message);
		
		
		GridPane statusBar = new GridPane();
		
		statusBar.setPadding(new Insets(10,10,10,10));
		statusBar.prefWidthProperty().bind(this.prefWidthProperty());
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
		statusBar.add(DoctorLabel, 1, 0);
		statusBar.add(PacientLabel, 0, 0);
		statusBar.getColumnConstraints().addAll(halfWidth,halfWidth);
		GridPane.setHalignment(DoctorLabel, HPos.RIGHT);
		getChildren().addAll(statusBar);
	}
	
	
}
