import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
 
public class InstructionScreen extends Application{
    Stage ps;

    public void start(Stage p){
        ps = p;
        showInstructions();
    }
 
    public void showInstructions() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Haven't you played this game?");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
 
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
            getClass().getResource("instructions.css").toExternalForm());
        dialogPane.getStyleClass().add(".dialog-pane");
 
        alert.setHeaderText("How to Play:");
        alert.setContentText(
            "Welcome to Ping Pong! "+
            "Are your reflexes fast enough, or will this game get the best of you?\n\n"+
            "When you're done reading, close this screen. "+
            "Click the level of your choice to start the real game. To interact with the game screen, "
            +"click on the 'Let's Play!' window."+"\n\nUse your paddle to keep the ball from "+
            "getting past you as it bounces off the walls. Can you do it until time runs out? "+
            "If you succeed, you'll be a Ping Pong champion! \n\nBeware: in the harder levels," + 
            " you might not see the timer though it will be behind the scenes, and will get extra balls!\n\nReady?" 
            +" Let's play!");
 
        ButtonType close = new ButtonType("Close");
  
        alert.getButtonTypes().setAll(close);
  
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == close){
            ps.close();
        }
    } 
}
