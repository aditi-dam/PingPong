import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class LoseScreen{
    
    public void start(Stage primaryStage){
        showLoseScreen();
    }
    
    public void showLoseScreen(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("LOSER!!!!!!");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        
        alert.setHeaderText("You lost.");
        alert.setContentText("Looks like you failed to hit the ball."+
        "And it wasn't a minute yet."+"Better luck next time!");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
            getClass().getResource("instructions.css").toExternalForm());
        dialogPane.getStyleClass().add(".dialog-pane2");
        alert.setTitle("Losing Screen");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, there was an error!");

        Platform.runLater(alert::showAndWait);
    }
}