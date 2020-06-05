import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
 
public class PingPong extends Application{
    private Stage ps;
    private Button win = new Button("Win");
    private Button lose = new Button("Lose");
    private Rectangle paddle = new Rectangle(70, 35);
    private Pane pane = new Pane(); 

    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Scene scene = new Scene(pane, 700, 400);
 
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        
        String source = new File("song.mp3").toURI().toString();
        Media media = null;
        media = new Media(source);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setStartTime(new Duration(0));
        mediaPlayer.play();
 
        Stop[] stops = new Stop[] { 
            new Stop(0, Color.DODGERBLUE),  
            new Stop(1, Color.RED)
        };  
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
        paddle.setFill(linearGradient); 
 
        paddle.setX(pane.getWidth()/2);
        paddle.setY(pane.getHeight() - 10);
        paddle.yProperty().bind(pane.heightProperty().subtract(10));
 
        pane.getChildren().add(paddle);
        Ball ball = new Ball(pane, paddle, ps);
 
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT){
                move(10);
            }
            else if(e.getCode() == KeyCode.LEFT){
                move(-10);
            }
        });
 
        // win.setOnAction(e -> win());
        // lose.setOnAction(e -> lose());

        drawClock();

        ps.setTitle("Shouldn't there be a game here?");
        ps.setScene(scene);
        ps.show();

    }
 
    public void win(){
        ps.close();
        WinScreen game = new WinScreen();
        game.start(ps);
    }
 
    public void lose(){
        ps.close();
        LoseScreen game = new LoseScreen();
        game.start(ps);
    }
 
    public void move(double x){
        paddle.setX(paddle.getX() + x); 
        if(paddle.getX() < 0){
            paddle.setX(0);
       }
       if(paddle.getX() > pane.getWidth()-paddle.getWidth()){
            paddle.setX(pane.getWidth() - paddle.getWidth());
       }
    }
    
    public void drawClock(){
        Stage clockStage = new Stage();
        HBox clock = new Clock();
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.show();
    }
}
