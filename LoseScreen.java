import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class LoseScreen extends Application{
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane(); 

        Scene scene = new Scene(pane); 
        ps.setTitle("LOSER!!!!!!");
        ps.setScene(scene); 
        ps.show();

    }

}