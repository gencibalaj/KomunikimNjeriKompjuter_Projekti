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
		ToolBarRight toolbar = new ToolBarRight();
		private static RightPart t;
		public RightPart(){
			t = this;
			toolbar.setOrientation(Orientation.VERTICAL);
			getChildren().add(toolbar);	
		}	
		
		public ToolBarRight getToolbar() {
			return toolbar;
		}
		
		public static RightPart getInstance() {
			return t;
		}
		
		public void toggleToolbar() {
			if(getChildren().contains(toolbar)) {
				getChildren().remove(toolbar);
			}else {
				getChildren().add(toolbar);
			}	
		}
		
}
