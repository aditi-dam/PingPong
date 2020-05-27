import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class PingPong extends Application{
    private Stage ps;
    private Button win = new Button("Win");
    private Button lose = new Button("Lose");
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Pane pane = new Pane(); 

        Paddle paddle = new Paddle(pane);
        paddle.draw();

        //pane.getChildren().addAll(win, lose);

        win.setOnAction(e -> win());
        lose.setOnAction(e -> lose());

        Scene scene = new Scene(pane); 
        primaryStage.setTitle("Shouldn't there be a game here?");
        primaryStage.setScene(scene);
        primaryStage.show();
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