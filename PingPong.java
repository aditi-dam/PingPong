import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

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
        
        Media media = new Media("song.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.play();
        //MediaView mediaView = new MediaView(mediaPlayer);

        // Button playButton = new Button(">");
        // playButton.setOnAction(e -> {
        //     if (playButton.getText().equals(">")) {
        //         mediaPlayer.play();
        //         playButton.setText("||");
        //     } else {
        //         mediaPlayer.pause();
        //         playButton.setText(">");
        //     }
        // });

        // HBox hBox = new HBox(10);
        // hBox.setAlignment(Pos.TOP_LEFT);
        // hBox.getChildren().addAll(playButton);

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

        win.setOnAction(e -> win());
        lose.setOnAction(e -> lose());

        
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
}