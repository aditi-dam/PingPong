import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

// Aditi test
public class PingPong extends Application{
    private Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane(); 

        Scene scene = new Scene(pane); 
        primaryStage.setTitle("Shouldn't there be a game here?");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}