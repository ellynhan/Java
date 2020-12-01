package hw7;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


import java.util.List;
import java.util.ArrayList;

public class ClockPane extends Pane{
	private int hour;
	private int minute;
	private int second;
	
	//Clock pane's width and height
	private double w = 250, h = 250;
	
	/** Construct a default clock with the current time */
	public ClockPane() {
		setCurrentTime();
	}
	
	/** Construct a clock with specified hour, minute, and second */
	public ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
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
	public void setW(double w) {
		this.w = w;
		paintClock();
	}
	
	/** Return clock pane's height */
	public double getH() {
		return h;
	}
	
	/** Set clock pane's width */
	public void setH(double h) {
		this.h = h;
		paintClock();
	}
	
	/** Set the current time for the clock */
	public void setCurrentTime() {
		//Construct a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
		
		//Set current hour, minute and second
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock();
		displayTime();
	}
	
	/** Set the fake time for the clock */
	public void setFakeTime() {
		//Construct a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
		
		//Set current hour, minute and second
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock();
		displayTime();
	}
	
	
	
	/** Paint the clock */
	protected void paintClock() {
		//Initialize clock parameters
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w/2;
		double centerY = h/2;
		
		//Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		//Draw lines of hours
		List<Text> printHours = new ArrayList<Text>();
		for(int i=1; i<=12; i++) {
			printHours.add(new Text(centerX + clockRadius * Math.sin(30 * i * (Math.PI / 180))*0.82-5, 
					centerY - clockRadius * Math.cos(30 * i * (Math.PI / 180))*0.85+5, String.valueOf(i)));
		}
		
		//Draw lines of minutes 
		List<Line> printMinutes = new ArrayList<Line>();
		for(int i=0; i<60; i++) {
			double lineStartX,lineStartY,lineEndX,lineEndY;
			if(i%5==0) {
				lineStartX=centerX + 0.92 * clockRadius * Math.sin(6 * i * (Math.PI / 180));
				lineStartY=centerY - 0.92 * clockRadius * Math.cos(6 * i * (Math.PI / 180));
			}else {
				lineStartX=centerX + 0.95 * clockRadius * Math.sin(6 * i * (Math.PI / 180));
				lineStartY=centerY - 0.95 * clockRadius * Math.cos(6 * i * (Math.PI / 180));
			}
			lineEndX=centerX + clockRadius * Math.sin(6 * i * (Math.PI / 180));
			lineEndY=centerY - clockRadius * Math.cos(6 * i * (Math.PI / 180));
			printMinutes.add(new Line(lineStartX,lineStartY,lineEndX,lineEndY));
		
		}
		
		//Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);
		
		//Draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLUE);
		
		//Draw minute hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI /12 ));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI /12 ));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);	
		
		getChildren().clear();
		getChildren().addAll(circle, sLine, mLine, hLine);
		getChildren().addAll(printMinutes);
		getChildren().addAll(printHours);

	}

	/** Display the Time */
	protected void displayTime() {
		String timeString = getHour() + ":" + getMinute()+ ":" + getSecond();
		Text displayText = new Text(w/2-23,h-2,timeString);
		getChildren().add(displayText);		
	}
}
