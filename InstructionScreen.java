import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
 
public class InstructionScreen{
    Stage ps;
  
    public void start(Stage primaryStage){
        ps = primaryStage;
        showInstructions();
    }
 
    public void showInstructions() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("How to Play:");
        alert.setContentText(
            "Welcome to Ping Pong!\n\nCan you keep the ball from bouncing offscreen "+
            "for the entire time, or will this game get the best of you?\n\n\n"+
            "After reading this page, click on the button to return to the "+
            "welcome screen. Then you can click the play button to start the real game. "+
            "Use your paddle to keep the ball from getting past you as it bounces off "+
            "the walls. Can you do it until time's up?\n"+
            "If you succeed, you'll be a Ping Pong champion!"+
            "Ready to start?");
 
        ButtonType backToWelcomeScreen = new ButtonType("Go back to Welcome Screen");
  
        alert.getButtonTypes().setAll(backToWelcomeScreen);
  
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == backToWelcomeScreen){
            WelcomeScreen game = new WelcomeScreen();
            game.start(ps);
        }
    }
 
}
