import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;

public class PingPong extends Application{
    private Stage ps;
    private Button win = new Button("Win");
    private Button lose = new Button("Lose");
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        ps.setWidth(350);
        ps.setHeight(350);
        Pane pane = new Pane(); 

        Paddle paddle = new Paddle(pane);
        paddle.draw();

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