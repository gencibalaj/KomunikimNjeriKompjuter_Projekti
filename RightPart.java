package projektiKNK;

import javafx.event.EventHandler;
import javafx.scene.input.TransferMode;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RightPart extends VBox{
	Image image = new Image("file:///C:/Users/ditjo/eclipse-workspace/OrdinancaMjeksore/src/projektiKNK/ordi2.png");
	ImageView img=new ImageView();
	
	String cssLayout ="-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" ;
	
		public RightPart()
		{
			Toolbar t = new Toolbar();
			t.setOrientation(Orientation.VERTICAL);
			getChildren().add(t);
			setStyle("-fx-backgroud-color:red;");
			//System.out.println("Eltioni");
		/*
		 *  img.setImage(image);
		 * img.setFitHeight(300);
		 * 
		 * img.setFitWidth(300); setAlignment(Pos.CENTER); setSpacing(150);
		 * setPadding(new Insets(10,10,10,10)); getChildren().addAll(img,new
		 * UserInfo(Name, Lname));
		 */
			
			setOnDragOver(new EventHandler<DragEvent>() {
			    public void handle(DragEvent event) {
			        if (event.getGestureSource() != this &&
			                event.getDragboard().hasString()) {
			        		
				  
			        }
			        
			        event.consume();
			    }
			});
		}	
}
