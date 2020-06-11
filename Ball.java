import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Ball{
    public final double radius = 10;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;
    private int SPEED = 10;
    private Pane pane;
    private Rectangle paddle;
    private Stage ps;
    private Stage clockStage;
    private PingPongManager pingPongManager;
    
    public Ball(Pane p, Rectangle q, Stage primaryStage, Stage cs, PingPongManager pp){
        pingPongManager = pp;
        circle.setFill(Color.WHITE); //Set ball color
        pane = p;
        paddle = q;
        ps = primaryStage;
        clockStage = cs;
        pane.getChildren().add(circle); //Place a ball into this pane
    
        //Create an animation for moving the ball
        animation = new Timeline(
            new KeyFrame(Duration.millis(SPEED), e->moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); //Start animation
    }
    
    public void play(){
        animation.play();
    }
    
    protected void moveBall(){
        if((x >= paddle.getX()) && (x <= paddle.getX() + paddle.getWidth()) && (y + radius >= paddle.getY())){
            dy *= -1;
        }
        if(x < radius || x > pane.getWidth() - radius){
            dx *= -1;
        }
        if(y < radius){
                dy *= -1; 
        }
        x += dx;
        y += dy;
        if(y > pane.getHeight()){
            y = 0;
            Stage ps = new Stage();
            LoseScreen game = new LoseScreen(clockStage);
            game.start(ps);
            clockStage.close();
            pingPongManager.gameOver();

        }
        circle.setCenterX(x);
        circle.setCenterY(y);
    
        
    }
    
    
    public void setSPEED(int sPEED) {
        SPEED = sPEED;
    }
    

}