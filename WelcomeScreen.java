import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class WelcomeScreen extends Application{
    private Button next = new Button("Next");
    
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane(); 

        next.setOnAction(e -> showNextScreen());

        Scene scene = new Scene(pane); 
        primaryStage.setTitle("The Scene is a real Pane");
        primaryStage.setScene(scene); 
        primaryStage.show();

    }

    public void showNextScreen(){
        System.out.println("Hi");
    }
}