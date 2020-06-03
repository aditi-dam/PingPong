import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

// import java.time.Duration;
import java.util.Timer;

public class Timer2 extends Application{
    private int x=100;
    private Label label;
    private Pane pane = new Pane();
    private int SPEED = 10;

    public void start(Stage ps){

        pane.getChildren().add(label);
        
        Scene scene = new Scene(pane); 
        ps.setTitle("Timer");
        ps.setScene(scene); 
        ps.show();
    }

    public void timer(){        
        Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(SPEED), e->countDown()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
            }
        } , 0, 1000);

    }

    public void countDown(){
        //do stuff
    }

}