import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoseScreen{
    
    public void start(Stage primaryStage){
        showLoseScreen();
    }
    
    public void showLoseScreen(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("LOSER!!!!!!");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, there was an error!");

        alert.showAndWait();
    }
}