import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Paddle{
    private Pane pane;
    private Rectangle rectangle;

    public Paddle(Pane pane){
        this.pane = pane;
    }
    public void draw(){
        rectangle = new Rectangle(pane.getWidth()/2 + 50, pane.getHeight()/2 + 50, 20, 20);
        pane.getChildren().add(rectangle);
    }

}