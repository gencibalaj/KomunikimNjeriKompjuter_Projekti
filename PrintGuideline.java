package projektiKNK;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.PrintResolution;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

public class PrintGuideline extends VBox {

	private Text namefromdb = new Text(MainProgram.getPacient().getFname());
	private Text lnamefromdb = new Text(MainProgram.getPacient().getLname());
	private Text nrpersonalfromdb = new Text(MainProgram.getPacient().getPersonalnr());
	private Text docnamefromdb = new Text(MainProgram.doctor.getDname() + " " + MainProgram.doctor.getLdname());
	private TextArea descripion = new TextArea();
	public static StackPane spane;
	VBox printPane = new VBox();
	
