import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class InstructionScreen extends Application{
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane();
        showInstructions();

        Scene scene = new Scene(pane); 
        ps.setTitle("Instructions");
        ps.setScene(scene); 
        ps.show();
    }

    public void showInstructions() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("How to Play:");
        alert.setContentText(
            "Welcome to Ping Pong!\n\nCan you keep the ball from bouncing offscreen "+
            "for the entire time, or will this game get the best of you?\n\n\n"+
            "After reading this page, click the OK button to return to the "+
            "welcome screen. Then you can click the play button to start the real game."+
            "\nUse your paddle to keep the ball from getting past you as it bounces off "+
            "the walls. Can you do it until time's up?\n"+
            "If you succeed, you'll be a Ping Pong champion! "+
            "Ready to start?");
    }

}