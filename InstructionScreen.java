import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class InstructionScreen extends Application{
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane(); 

        Scene scene = new Scene(pane); 
        ps.setTitle("How to Play:");
        ps.setScene(scene); 
        ps.show();

    }

}