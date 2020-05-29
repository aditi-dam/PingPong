import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class PingPong extends Application{
    private Stage ps;
    private Button win = new Button("Win");
    private Button lose = new Button("Lose");
    private Rectangle paddle = new Rectangle(70, 35, Color.BLACK);
    private Pane pane = new Pane(); 
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Scene scene = new Scene(pane, 200, 200); 
        paddle.setX(pane.getWidth()/2);
        paddle.setY(pane.getHeight() - 10);
        paddle.yProperty().bind(pane.heightProperty().subtract(10));
        pane.getChildren().add(paddle);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT){
                move(10);
            }
            else if(e.getCode() == KeyCode.LEFT){
                move(-10);
            }
        });

        win.setOnAction(e -> win());
        lose.setOnAction(e -> lose());

        
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

    public void move(double x){
        paddle.setX(paddle.getX() + x); 
        if(paddle.getX() < 0){
            paddle.setX(0);
       }
       if(paddle.getX() > pane.getWidth()-paddle.getWidth()){
            paddle.setX(pane.getWidth() - paddle.getWidth());
       }
    }

}