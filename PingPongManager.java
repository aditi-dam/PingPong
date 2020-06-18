import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PingPongManager extends Application {

    Pane welcomeScreen;
    private Stage clockStage;
    //changes
    Pane playScreen;

    Stage primaryStage;
    private Integer counter = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        primaryStage = stage;
        welcomeScreen = new WelcomeScreen(this);
        Scene scene = new Scene(welcomeScreen);
        primaryStage.setTitle("Let's play!");
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
        clock.setAlignment(Pos.CENTER);
        clockStage.setWidth(400);
        clockStage.setHeight(120);
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.setX(primaryStage.getX()+ primaryStage.getWidth() - 550);
        clockStage.setY(primaryStage.getY()+550);
        clockStage.show();

        playScreen = new PingPong(this, scene, clockStage);

        scene.setRoot(playScreen);
        playScreen.requestFocus();

    }

    public void showMediumScreen(){
        Scene scene = primaryStage.getScene();

        clockStage = new Stage();
        Clock clock = new Clock(this, clockStage);
        clock.setAlignment(Pos.CENTER);
        clockStage.setWidth(400);
        clockStage.setHeight(120);
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.setX(primaryStage.getX()+ primaryStage.getWidth() - 550);
        clockStage.setY(primaryStage.getY()+550);
        clockStage.show();

        playScreen = new Medium(this, scene, clockStage, clock);

        scene.setRoot(playScreen);
        playScreen.requestFocus();

    }

    public void showHardScreen(){
        Scene scene = primaryStage.getScene();

        Stage clockStage = new Stage();
        Clock clock = new Clock(this, clockStage);
        clock.setAlignment(Pos.CENTER);
        clockStage.setWidth(400);
        clockStage.setHeight(120);
        Scene clockScene = new Scene(clock, 700, 400);
        clockStage.setTitle("Clock");
        clockStage.setScene(clockScene);
        clockStage.setX(primaryStage.getX()+ primaryStage.getWidth()-550);
        clockStage.setY(primaryStage.getY()+550);
        clockStage.show();

        playScreen = new Hard(this, scene, clockStage, clock);

        scene.setRoot(playScreen);
        playScreen.requestFocus();
    }

    public void gameOver(Boolean winner){
        primaryStage.close();
        if(counter == 0 && winner){
            WinScreen game = new WinScreen();
            game.start(primaryStage);
            counter++;
        }
        else if(counter == 0 && !winner){
            LoseScreen game = new LoseScreen(primaryStage);
            game.start(primaryStage);
            counter++;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}