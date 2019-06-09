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
	
	HBox h1 = new HBox(50);
	HBox h2 = new HBox(20);
	HBox h3 = new HBox(20);
	HBox h4 = new HBox(20);
	HBox h5 = new HBox(20);
	HBox h6 = new HBox(20);
	HBox h7 = new HBox(20);
	HBox h8 = new HBox(20);
	Image image = new Image("projektiKNK/ordi2.png");
	ImageView img = new ImageView();
	public PrintGuideline() {
		setPadding(new Insets(50, 10, 10, 10));
		printPane.setSpacing(20);
		printPane.setMinHeight(842);
		printPane.setMinWidth(595);
		h1.setAlignment(Pos.CENTER);
		h2.setAlignment(Pos.TOP_LEFT);
		h3.setAlignment(Pos.TOP_LEFT);
		h4.setAlignment(Pos.TOP_LEFT);
		h5.setAlignment(Pos.TOP_LEFT);
		h6.setAlignment(Pos.CENTER);
		h7.setAlignment(Pos.BOTTOM_CENTER);

		img.setImage(image);

		img.setFitHeight(180);
		img.setFitWidth(180);

		h1.getChildren().addAll(img, new Text("ORDINANCA MJEKSORE"));
		h2.getChildren().addAll(new Label("First Name"), namefromdb);
		h3.getChildren().addAll(new Label("Last Name"), lnamefromdb);
		h4.getChildren().addAll(new Label("Personal Number"), nrpersonalfromdb);
		h5.getChildren().addAll(new Label("Medical Guideliness:"));
		h6.getChildren().addAll(descripion);
		h7.getChildren().addAll(new Label("Releast by:"), docnamefromdb);
		descripion.setPrefHeight(300);
		descripion.setPrefWidth(600);
		Button b = new Button("Print");
		
		printPane.getChildren().addAll(h1, h2, h3, h4, h5, h6, h7);
		getChildren().addAll(printPane,b);
		b.setOnAction(e->{
			Print(printPane);
		});
		
		
	}
	
	public static void Print(Pane root) {
		PrinterJob job = PrinterJob.createPrinterJob();
		if(job != null){
			job.showPrintDialog(root.getScene().getWindow());
			Printer printer = job.getPrinter();
			PageLayout pageLayout = printer.createPageLayout(Paper.A4,
				PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
			boolean success = job.printPage(pageLayout, root);
			if(success) {
				job.endJob();
			}
		}	 
	}



}
