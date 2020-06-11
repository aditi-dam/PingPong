import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PingPongManager extends Application {

    Pane welcomeScreen;
    Pane playScreen;

    Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        primaryStage = stage;
        welcomeScreen = new WelcomeScreen(this);
        Scene scene = new Scene(welcomeScreen);
        primaryStage.setTitle("Multi-screen Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showWelcomeScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(welcomeScreen);
    }


    public void showPlayScreen(){
        Scene scene = primaryStage.getScene();

        Stage clockStage = new Stage();
        HBox clock = new Clock(this, clockStage);
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.setX(primaryStage.getX()+ primaryStage.getWidth() + 30);
        clockStage.setY(primaryStage.getY());
        clockStage.show();

        playScreen = new PingPong(this, scene, clockStage);

        scene.setRoot(playScreen);
        playScreen.requestFocus();

    }

    public void gameOver(){
        primaryStage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}