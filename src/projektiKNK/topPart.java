package projektiKNK;

import javafx.scene.layout.VBox;

public class topPart extends VBox {
	private Toolbar toolbar =  new Toolbar();
	private static topPart t;
	public topPart(){
		getChildren().addAll(new Menubar(), toolbar);
		t = this; 
	}
	
	public Toolbar getToolbar() {
		return toolbar;
	}
	
	public static topPart getInstance() {
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
