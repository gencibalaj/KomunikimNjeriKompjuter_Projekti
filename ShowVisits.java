package projektiKNK;

import java.sql.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.AlignmentAction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShowVisits extends VBox {
	String cssLayout = 
            "-fx-font-size: 20px;\n"+
            "-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" ;
	Button Delete=new Button("Delete");
		