import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class WelcomeScreen extends Application{
    private Button next = new Button("Next");
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane(); 

        pane.getChildren().add(next);
        next.setOnAction(e -> showNextScreen());

        Scene scene = new Scene(pane); 
        ps.setTitle("The Scene is a real Pane");
        ps.setScene(scene); 
        ps.show();

    }

    public void showNextScreen(){
        ps.close();
        PingPong game = new PingPong();
        game.start(ps);
    }
}