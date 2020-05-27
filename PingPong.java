import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

public class PingPong extends Application{
    private Stage ps;
    private Button win = new Button("Win");
    private Button lose = new Button("Lose");
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        GridPane pane = new GridPane(); 
        pane.add(win, 0, 0);
        pane.add(lose, 0, 1);

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