import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PingPongManager extends Application {

    Pane welcomeScreen;
    //changes
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
        clockStage.setWidth(400);
        clockStage.setHeight(120);
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.setX(primaryStage.getX()+ primaryStage.getWidth() - 550);
        clockStage.setY(primaryStage.getY()+450);
        clockStage.show();

        playScreen = new PingPong(this, scene, clockStage);

        scene.setRoot(playScreen);
        playScreen.requestFocus();

    }

    public void showMediumScreen(){
        Scene scene = primaryStage.getScene();

        Stage clockStage = new Stage();
        Clock clock = new Clock(this, clockStage);
        clockStage.setWidth(400);
        clockStage.setHeight(120);
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.setX(primaryStage.getX()+ primaryStage.getWidth() - 400);
        clockStage.setY(primaryStage.getY()+400);
        clockStage.show();

        playScreen = new Medium(this, scene, clockStage, clock);

        scene.setRoot(playScreen);
        playScreen.requestFocus();

    }

    public void showHardScreen(){
        Scene scene = primaryStage.getScene();

        Stage clockStage = new Stage();
        Clock clock = new Clock(this, clockStage);
        clockStage.setWidth(400);
        clockStage.setHeight(120);
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.setX(primaryStage.getX()+ primaryStage.getWidth());
        clockStage.setY(primaryStage.getY()+400);
        clockStage.show();

        playScreen = new Hard(this, scene, clockStage, clock);

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