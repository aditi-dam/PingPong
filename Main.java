import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer; 
import javafx.stage.Stage;

public class Main extends Application {
   @Override
   public void start(Stage stage) throws Exception {
        String s = "song.mp3";
        Media h = new Media(Paths.get(s).toUri().toString()); 
        MediaPlayer mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
       BorderPane pane = new BorderPane();
       Scene scene = new Scene(pane, 600, 400);
       stage.setScene(scene);
       stage.setTitle("Playing music with JavaFX");
       stage.show();
   }  

//    private MediaPlayer mediaPlayer; 
//    public void music() {
//        String s = "song.mp3";
//        Media h = new Media(Paths.get(s).toUri().toString()); 
//        mediaPlayer = new MediaPlayer(h);
//        mediaPlayer.play();
//    }
 }