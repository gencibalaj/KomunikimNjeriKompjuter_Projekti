package projektiKNK;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Help {

	public static void showHelp() {

		Stage stage = new Stage();
		
		WebView browser = new WebView();

		WebEngine webEngine = browser.getEngine();

		String url = Help.class.getResource("help_al.html").toExternalForm();
		webEngine.load(url);

		Scene scene = new Scene(browser);

		stage.setTitle("Help - About");
		stage.setScene(scene);

		stage.show();
	}

}