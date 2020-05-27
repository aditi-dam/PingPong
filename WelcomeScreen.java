import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

public class WelcomeScreen extends Application{
    private Button next = new Button("Next");
    private Button instructions = new Button("Instructions");
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        GridPane pane = new GridPane(); 

        pane.add(next, 0, 0);
        pane.add(instructions, 0, 1);

        next.setOnAction(e -> showNextScreen());
        instructions.setOnAction(e -> showInstructionsScreen());

        Scene scene = new Scene(pane); 
        ps.setTitle("The Scene is a real Pane");
        ps.setScene(scene); 
        ps.show();

    }

    public void showNextScreen(){
        ps.close();
        PingPong game = new PingPong();
        game.start(ps);
    }

    public void showInstructionsScreen(){
        ps.close();
        InstructionScreen game = new InstructionScreen();
        game.start(ps);
    }
}