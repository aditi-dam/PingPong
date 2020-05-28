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
        rectangle = new Rectangle();
        rectangle.xProperty().bind(pane.widthProperty().divide(2));
        rectangle.yProperty().bind(pane.heightProperty().subtract(10));
        pane.getChildren().add(rectangle);
    }

}
