import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class WinScreen extends Application{
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane(); 

        Scene scene = new Scene(pane); 
        ps.setTitle("You've finally won. Took you a while.");
        ps.setScene(scene); 
        ps.show();

    }

}