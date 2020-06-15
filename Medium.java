import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Medium extends PingPong {
    private Ball ball;
    private Clock clock;
    private Ball ball2;
    private Scene scene;
    private Boolean ballExists = false;

    public Medium(PingPongManager p, Scene s, Stage cs,  Clock c) {
        super(p, s, cs);
        scene = s;
        clock = c;
        ball = new Ball(this, this.paddle, this.ps, this.clockStage, this.pingPongManager);
    } 
    
    @Override
    public void move(double x){
        paddle.setX(paddle.getX() + x); 
        if(paddle.getX() < 0){
            paddle.setX(0);
       }
       if(paddle.getX() > this.getWidth()-paddle.getWidth()){
            paddle.setX(this.getWidth() - paddle.getWidth());
       }
       if(clock.getSeconds() <= 55){
        generateNewBall();
       }
    }

    public void generateNewBall(){
        if(!ballExists){
            ball2 = new Ball(this, this.paddle, this.ps, this.clockStage, this.pingPongManager);
            ball2.setX(scene.getWidth() - 30);
            ballExists = true;
        }
    }


    
}