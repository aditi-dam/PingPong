import java.util.TimerTask;
import java.util.Timer;

public class Timer2{
    private int x=100;

    public void timer(){        
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
                if(x >= 0){
                    System.out.println(x);
                    x--;
                }
            }
        } , 0, 1000);

    }

}