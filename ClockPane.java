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
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	/** Return hour */
	public int getHour() {
		return hour;
	}

	/** Set a new hour */
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}

	/** Return minute */
	public int getMinute() {
		return minute;
	}

	/** Set a new minute */
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}

	/** Return second */
	public int getSecond() {
		return second;
	}

	/** Set a new second */
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}

	/** Return clock pane's width */
	public double getW() {
		return w;
	}

	/** Set clock pane's width */
	public void getW(double w) {
		this.w = w;
		paintClock();
	}

	/** Return clock pane's height */
	public double getH() {
		return h;
	}

	/** Set clock pane's heigt */
	public void setH(double h) {
		this.h = h;
		paintClock();
	}

	/* Set the current time for the clock */
	public void setCurrentTime() {
		// Construct a Calendar for the current date and time
		Calendar calendar = new GregorianCalendar();

		// Set current hour, minute and second
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock(); // Repaint the clock
	}
	
	/** Paint the clock */
	protected void paintClock() {
		
		// Initialize clock parameters
		double clockRadius = 100/2;
		double centerX = w / 2.0;
		double centerY = h / 2.0;

		// Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);
		getChildren().clear();
		for(int i = 0; i < 12; i++) {
			Text t = new Text(Math.cos(i*Math.PI/6-Math.PI/3)*clockRadius+centerX,Math.sin(i*Math.PI/6-Math.PI/3)*clockRadius+centerY,(i+1)+"");
			t.setStyle("-fx-font-weight: bold;-fx-font-size:10");
			this.getChildren().add(t);
		}
		// Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength *
			Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength *
			Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.BLACK);

		// Draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength *
			Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength *
			Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLACK);

		// Draw hour hand 
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength *
			Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * 
			Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.BLACK);

		
		getChildren().addAll(sLine, mLine, hLine);
	}

