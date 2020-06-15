import java.io.File;

import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
 
public class PingPong extends Pane{

    protected Stage ps;
    protected Rectangle paddle;
    protected Stage clockStage;
    protected PingPongManager pingPongManager;
    private Scene scene;

    
    public PingPong(PingPongManager p, Scene s, Stage cs){
        clockStage = cs;
        scene = s;
        pingPongManager = p;
 
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        
        String source = new File("song.mp3").toURI().toString();
        Media media = null;
        media = new Media(source);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setStartTime(new Duration(0));
        mediaPlayer.play();

        drawPaddle();
        Ball ball = new Ball(this, paddle, ps, clockStage, pingPongManager);

        this.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT){
                move(11);
            }
            else if(e.getCode() == KeyCode.LEFT){
                move(-11);
            }
        });

    }
    
    public void move(double x){
        paddle.setX(paddle.getX() + x); 
        if(paddle.getX() < 0){
            paddle.setX(0);
       }
       if(paddle.getX() > this.getWidth()-paddle.getWidth()){
            paddle.setX(this.getWidth() - paddle.getWidth());
       }
    }

    public void drawPaddle(){
        paddle = new Rectangle(70, 35);
 
        Stop[] stops = new Stop[] { 
            new Stop(0, Color.DODGERBLUE),  
            new Stop(1, Color.RED)
        };  
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
        paddle.setFill(linearGradient); 
 
        paddle.setX(this.getWidth()/2 + 300);
        paddle.setY(this.getHeight() - 10);
        paddle.yProperty().bind(this.heightProperty().subtract(10));
 
        this.getChildren().add(paddle);
    }
    
}   