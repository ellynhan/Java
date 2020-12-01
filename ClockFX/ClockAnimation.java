package hw7;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import java.io.File;

public class ClockAnimation extends Application {

	@Override //Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception {
		ClockPane clock = new ClockPane(); // Create a clock;	
		// Create a handler for animation
		EventHandler<ActionEvent> eventHandler = e ->{
			clock.setCurrentTime(); // Set a new clock time
			
			//o'clock, alarm the hour. 
			if(clock.getMinute()==0 && clock.getSecond()==0) {
				int hour = clock.getHour();
				if(hour>=12) hour-=12;
				//play the sound(audio file, which name is 0h.mp3,1h.mp3 ..., or 11h.mp3)
				new AudioClip(new File(hour+"h.mp3").toURI().toString()).play();
			}
		};
		
		// Create an animation for a running clock
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(clock, 250, 270);
		primaryStage.setTitle("ClockAnimation"); //Set the stage title
		primaryStage.setScene(scene);//Place the scene in the stage
		primaryStage.show();//Display the stage

	}
}
