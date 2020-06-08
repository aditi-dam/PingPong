import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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
import javafx.geometry.Pos;
import java.lang.reflect.Method;

public class WelcomeScreen extends Application{
    private PingPongManager pingPongManager;
    private Text text1 = new Text("Welcome to Ping Pong"); 
    private Text text2 = new Text("Are you ready to have some fun?");
    private Text filler1 = new Text("");
    private Text filler2 = new Text("");
    private Button next = new Button("Play");
    private Button instructions = new Button("Instructions");
    Stage ps;
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        VBox gridPane = new VBox(); 
        
        gridPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Stop[] stops = new Stop[] { 
            new Stop(0, Color.DODGERBLUE),  
            new Stop(1, Color.RED)
        };  
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
        text1.setFill(linearGradient); 
        text1.setFont(Font.font ("Phosphate",65)); 

        text2.setFill(linearGradient);
        text2.setFont(Font.font ("Bradley Hand", 40));

        filler1.setFill(Color.BLACK);
        filler2.setFill(Color.BLACK);

        Image image = new Image("unnamed.png", 150, 150, false, false);

        next.setStyle("-fx-background-color: DODGERBLUE");
        next.setFont(Font.font("Marker Felt", 20));

        instructions.setStyle("-fx-background-color: RED");
        instructions.setFont(Font.font("Marker Felt", 20));
        //instructions.setStyle("-fx-font-size:20");

        next.setOnAction(e -> showNextScreen());
        instructions.setOnAction(e -> showInstructionsScreen());

        gridPane.setAlignment(Pos.CENTER);
        gridPane.getChildren().addAll(text1, text2, filler1, next, filler2, instructions, new ImageView(image)); 

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