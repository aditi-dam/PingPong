import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.CycleMethod; 
import javafx.scene.paint.LinearGradient; 
import javafx.scene.paint.Stop; 
import javafx.geometry.HPos;
import javafx.geometry.Pos;

public class WelcomeScreen extends Application{
    private Text text = new Text("Welcome to Ping Pong"); 
    private Text text2 = new Text("Are you ready to have some fun?");
    private Button next = new Button("Play");
    private Button instructions = new Button("Instructions");
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        GridPane gridPane = new GridPane(); 
        
        gridPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Stop[] stops = new Stop[] { 
            new Stop(0, Color.DODGERBLUE),  
            new Stop(1, Color.RED)
        };  
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
        text.setFill(linearGradient); 
        text.setFont(Font.font ("Phosphate",65)); 

        text2.setFill(linearGradient);
        text2.setFont(Font.font ("Bradley Hand", 40));

        Image image = new Image("unnamed.png", 150, 150, false, false);

        next.setStyle("-fx-background-color: DODGERBLUE");
        next.setFont(Font.font("Marker Felt", 20));

        instructions.setStyle("-fx-background-color: RED");
        instructions.setFont(Font.font("Marker Felt", 20));
        //instructions.setStyle("-fx-font-size:20");

        next.setOnAction(e -> showNextScreen());
        instructions.setOnAction(e -> showInstructionsScreen());

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(text,0,0);
        gridPane.setVgap(7);
        gridPane.add(text2, 0, 1);
        GridPane.setHalignment(text2, HPos.CENTER);
        gridPane.add(next, 0, 2);
        GridPane.setHalignment(next, HPos.CENTER);
        gridPane.add(instructions, 0, 4);
        GridPane.setHalignment(instructions, HPos.CENTER);
        gridPane.add(new ImageView(image),0,5);
        GridPane.setHalignment(new ImageView(image), HPos.CENTER); //The image won't center
        
        Scene scene = new Scene(gridPane); 
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