import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Hard extends Medium {
    private Ball ball2;
    private Scene scene;
    private Boolean ballExists = false;


    public Hard(PingPongManager p, Scene s, Stage cs,  Clock c) {
        super(p, s, cs, c);
        scene = s;
    }

    @Override
    public void generateNewBall(){
        if(!ballExists){
            ball2 = new Ball(this, this.paddle, this.ps, this.clockStage, this.pingPongManager);
            ball2.setX(scene.getWidth() - 30);
            ballExists = true;
        }
    }
}