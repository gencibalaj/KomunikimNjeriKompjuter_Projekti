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

	private double w = 180, h = 180;

	
	public ClockPane() {
		setStyle("-fx-effect: dropshadow(gaussian,lightgrey,2,2,1,1);" );
		setPrefSize(w, h);
		setCurrentTime();
		animation = new Timeline(
			new KeyFrame(Duration.millis(1000), e -> moveClock()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

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

	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock(); 
	}
	
	protected void paintClock() {
		
		double clockRadius = 100/2;
		double centerX = w / 2.0;
		double centerY = h / 2.0;

		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);
		getChildren().clear();
		for(int i = 0; i < 12; i++) {
			Text t = new Text(Math.cos(i*Math.PI/6-Math.PI/3)*clockRadius+centerX,Math.sin(i*Math.PI/6-Math.PI/3)*clockRadius+centerY,(i+1)+"");
			t.setStyle("-fx-font-weight: bold;-fx-font-size:10");
			this.getChildren().add(t);
		}
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength *
			Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength *
			Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.BLACK);

		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength *
			Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength *
			Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLACK);

		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength *
			Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * 
			Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.BLACK);

		
		getChildren().addAll(sLine, mLine, hLine);
	}

	protected void moveClock() {
		if (minute == 60) {
			hour += 1; 
		}	
		if (second == 60) {
			minute += 1;
		}
		second = (second < 60 ? second + 1 : 1);
		paintClock();	
	}
}