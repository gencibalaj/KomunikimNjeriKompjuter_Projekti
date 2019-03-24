package projektiKNK;

import java.time.LocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AddPacient extends GridPane {

	private TextField FName = new TextField();
	private TextField Place = new TextField();
	private TextField LName = new TextField();
	private TextField PersonalNr = new TextField();
	private RadioButton Male = new RadioButton("Male");
	private RadioButton Female = new RadioButton("Female");
	private DatePicker BDay = new DatePicker();
	private Button Clear = new Button("Clear");

	private Button Add = new Button("Add");
	private Button Update = new Button("Update");

	private TextField RHFactor = new TextField();
	private TextField BloodType = new TextField();
	private TextField Allergies = new TextField();
	private TextField Vaccination = new TextField();
	private Label GenderLabel = I18N.getLabel("Gender");

	ToggleGroup toggleGroup = new ToggleGroup();

	String cssLayout = "-fx-font-size: 20px;\n" + "-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);";

	public AddPacient(Pacient p) {
		this();
		FName.setText(p.getFname());
		LName.setText(p.getLname());
		PersonalNr.setText(p.getPersonalnr());
		BDay.setValue(p.getBday());
		RHFactor.setText(p.getRhfactory());
		Allergies.setText(p.getAllergiers());
		Vaccination.setText(p.getVaccinations());
		Place.setText(p.getPlace());
		BloodType.setText(p.getBloodtype());

		add(Update, 5, 6);
		Update.setVisible(true);
		Add.setVisible(false);
		
		Update.setOnAction(e->{ 
			if(Validate()) {
				Pacient.updateInPacient(p.getPid(), FName.getText(),LName.getText(), 
				BDay.getValue(), Place.getText(), p.getGender(),
				RHFactor.getText(), BloodType.getText(),Vaccination.getText(), 
				Allergies.getText(), PersonalNr.getText()); 
			}	
		});
		 

	}
