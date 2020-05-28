import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;

public class PingPong extends Application{
    private Stage ps;
    private Button win = new Button("Win");
    private Button lose = new Button("Lose");
    private Rectangle paddle = new Rectangle(70, 35, Color.BLACK);
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane(); 
        paddle.setX(pane.getWidth()/2);
        paddle.setY(pane.getHeight() - 10);
        paddle.xProperty().bind(pane.widthProperty().divide(2));
        paddle.yProperty().bind(pane.heightProperty().subtract(10));
        pane.getChildren().add(paddle);

        //pane.getChildren().addAll(win, lose);

        win.setOnAction(e -> win());
        lose.setOnAction(e -> lose());

        Scene scene = new Scene(pane, 200, 200); 
        ps.setTitle("Shouldn't there be a game here?");
        ps.setScene(scene);
        ps.show();
    }

    public void win(){
        ps.close();
        WinScreen game = new WinScreen();
        game.start(ps);
    }

    public void lose(){
        ps.close();
        LoseScreen game = new LoseScreen();
        game.start(ps);
    }

}