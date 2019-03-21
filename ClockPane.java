package projektiKNK;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.animation.KeyFrame;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	private Timeline animation;

	// Clock pane's width and height
	private double w = 180, h = 80;

	/** Construct a default clock with the current time */
	public ClockPane() {
		setStyle("-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" );
		setPrefSize(w, h);
		setCurrentTime();
		animation = new Timeline(
			new KeyFrame(Duration.millis(1000), e -> moveClock()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	/** Construct a click with specified hour, minute, and second */
	public ClockPane(int hour, int minute, int second) {
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
		animation = new Timeline(
			new KeyFrame(Duration.millis(1000), e -> moveClock()));
	