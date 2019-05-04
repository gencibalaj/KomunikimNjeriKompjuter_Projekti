package projektiKNK;

import javafx.scene.layout.VBox;

public class topPart extends VBox {
	private static Toolbar toolbar;
	public topPart(){
		toolbar = new Toolbar();
		getChildren().addAll(new Menubar(), toolbar);
	}
	public static Toolbar getToolbar() {
		return toolbar;
	}
	

}
