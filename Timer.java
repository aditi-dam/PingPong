import java.util.TimerTask;
import java.util.Timer;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Timer {
    Timer timer;

    public Timer(int seconds) {
        // timer = new Timer();
        timer.schedule(new RemindTask());
	}

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new Timer(60);
    }
}