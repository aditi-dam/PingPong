import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
 
public class InstructionScreen{
    Stage ps;
  
    public void start(Stage primaryStage){
        ps = primaryStage;
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
            "Welcome to Ping Pong!\n"+
            "Are your reflexes fast enough, or will this game get the best of you?\n\n"+
            "When you're done reading, click on the 'Return to Welcome Screen' button. "+
            "\nClick 'Next' to start the real game. \nUse your paddle to keep the ball from "+
            "getting past you as it bounces off the walls. Can you do it until time runs out? "+
            "\nIf you succeed, you'll be a Ping Pong champion! \nReady? Let's play!");

        ButtonType backToWelcomeScreen = new ButtonType("Return to Welcome Screen");
  
        alert.getButtonTypes().setAll(backToWelcomeScreen);
  
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == backToWelcomeScreen){
            WelcomeScreen game = new WelcomeScreen();
            game.start(ps);
        }
    } 
}
