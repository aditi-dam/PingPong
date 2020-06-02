import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.CycleMethod; 
import javafx.scene.paint.LinearGradient; 
import javafx.scene.paint.Stop; 
import javafx.geometry.HPos;
import javafx.geometry.Pos;

public class Timer extends Application{
    Stage ps;
    Pane pane;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;

        Scene scene = new Scene(pane); 
        ps.setTitle("Timer");
        ps.setScene(scene); 
        ps.show();

    }

}