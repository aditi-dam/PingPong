import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Hard extends PingPong{
    private Ball ball;
    private Clock clock;
    private Ball ball2;
    private Ball ball3;
    public Integer counter = 1;
    private Scene scene;
    //private Boolean ballExists = false;

    public Hard(PingPongManager p, Scene s, Stage cs,  Clock c) {
        super(p, s, cs);
        scene = s;
        clock = c;
        ball = new Ball(this, this.paddle, this.ps, this.clockStage, this.pingPongManager);
    } 

    public void move(double x){
        paddle.setX(paddle.getX() + x);
        if(paddle.getX() < 0){
            paddle.setX(0);
        }
        if(paddle.getX() > this.getWidth()-paddle.getWidth()){
            paddle.setX(this.getWidth() - paddle.getWidth());
        }
        if((clock.getSeconds() <= 55)){
            generateNewBall(ball2);
        }
        if((clock.getSeconds() <= 20)){
            generateNewBall(ball3);
        }

    }

    public void generateNewBall(Ball ball2){
        if(counter < 2){
            ball2 = new Ball(this, this.paddle, this.ps, this.clockStage, this.pingPongManager);
            ball2.setX(scene.getWidth() - 30);
            counter = 2;
        }
        else if (counter < 3 && clock.getSeconds() <= 20) {
            ball2 = new Ball(this, this.paddle, this.ps, this.clockStage, this.pingPongManager);
            ball2.setX(scene.getWidth() - 130);
            counter = 3;
        }
    }
}