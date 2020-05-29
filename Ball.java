import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ball extends Pane{
    public final double radius = 10;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;
    private int SPEED = 25;

    public Ball(){
        circle.setFill(Color.GREEN); //Set ball color
        getChildren().add(circle); //Place a ball into this pane

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
        // Check boundaries
        if(x < radius || x > getWidth() - radius){
            dx *= -1; //Change ball move direction
        }
        if(y < radius || y > getHeight() - radius){
            dy *= -1; //Change ball move direction
        }

        //Adjust ball position
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public void setSPEED(double sPEED) {
        SPEED = sPEED;
    }

}