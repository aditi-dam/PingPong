import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class PingPong extends Application{
    private Stage ps;
    private Button win = new Button("Win");
    private Button lose = new Button("Lose");
    private Rectangle paddle = new Rectangle(70, 35);
    private Pane pane = new Pane(); 
    
    @Override
    public void start(Stage primaryStage){
        ps = primaryStage;
        Scene scene = new Scene(pane, 200, 200); 

        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null))); 

        Stop[] stops = new Stop[] { 
            new Stop(0, Color.DODGERBLUE),  
            new Stop(1, Color.RED)
        };  
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
        paddle.setFill(linearGradient); 

        paddle.setX(pane.getWidth()/2);
        paddle.setY(pane.getHeight() - 10);
        paddle.yProperty().bind(pane.heightProperty().subtract(10));

        pane.getChildren().add(paddle);
        Ball ball = new Ball(pane);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT){
                move(10);
            }
            else if(e.getCode() == KeyCode.LEFT){
                move(-10);
            }
        });

        win.setOnAction(e -> win());
        lose.setOnAction(e -> lose());

        
        ps.setTitle("Shouldn't there be a game here?");
        ps.setScene(scene);
        ps.show();
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

    public void move(double x){
        paddle.setX(paddle.getX() + x); 
        if(paddle.getX() < 0){
            paddle.setX(0);
       }
       if(paddle.getX() > pane.getWidth()-paddle.getWidth()){
            paddle.setX(pane.getWidth() - paddle.getWidth());
       }
    }

    class Ball{
        public final double radius = 10;
        private double x = radius, y = radius;
        private double dx = 1, dy = 1;
        private Circle circle = new Circle(x, y, radius);
        private Timeline animation;
        private int SPEED = 15;
        private Pane pane;
    
        public Ball(Pane p){
            circle.setFill(Color.WHITE); //Set ball color
            pane = p;
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
                System.out.println("In/on paddle");
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
            circle.setCenterX(x);
            circle.setCenterY(y);

            
        }

    
        public void setSPEED(int sPEED) {
            SPEED = sPEED;
        }
    
    }

}