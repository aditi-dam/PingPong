import javafx.stage.Stage;
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

public class WelcomeScreen extends VBox{
    private PingPongManager pingPongManager;
    private Text text1 = new Text("Welcome to Ping Pong"); 
    private Text text2 = new Text("Are you ready to have some fun?");
    private Text filler1 = new Text("");
    private Text filler2 = new Text("");
    private Text filler3 = new Text("");
    private Text filler4 = new Text("");
    private Button easy = new Button("Easy");
    private Button medium = new Button("Medium");
    private Button hard = new Button("Hard");
    private Button instructions = new Button("Instructions");
    
    public WelcomeScreen(PingPongManager p){
        super(); 
        pingPongManager = p;
        
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

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

        Image image = new Image("image.png", 150, 150, false, false);

        easy.setStyle("-fx-background-color: DODGERBLUE");
        easy.setFont(Font.font("Marker Felt", 20));
        medium.setStyle("-fx-background-color: DODGERBLUE");
        medium.setFont(Font.font("Marker Felt", 20));
        hard.setStyle("-fx-background-color: DODGERBLUE");
        hard.setFont(Font.font("Marker Felt", 20));

        instructions.setStyle("-fx-background-color: RED");
        instructions.setFont(Font.font("Marker Felt", 20));

        instructions.setOnAction(e -> showInstructionsScreen());
        easy.setOnAction(e -> showEasyScreen());
        medium.setOnAction(e -> showMediumScreen());
        hard.setOnAction(e -> showHardScreen());

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(text1, text2, filler1, easy, filler2, medium, filler3, hard, filler4, instructions, new ImageView(image)); 


    }

    private void showInstructionsScreen(){
        Stage ps = new Stage();
        InstructionScreen game = new InstructionScreen();
        game.start(ps);
    }

    public void showEasyScreen(){
        pingPongManager.showPlayScreen();
    }

    public void showMediumScreen(){
        pingPongManager.showMediumScreen();
    }

    public void showHardScreen(){
        pingPongManager.showHardScreen();
    }
}