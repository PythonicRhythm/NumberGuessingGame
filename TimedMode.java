

/*
 * This class simulates a timer that is used in the Timed Mode version
 * of the Guessing Game. This class is used to keep track of the amount
 * of time spent guessing the correct value and to make sure the game closes
 * when the timeLimit is reached.
 */
public class TimedMode extends Thread {
    
    private int timeLimit;  // The maximum amount of seconds the user has to guess.
    private int answer;     // The correct answer choice the user is looking for.
    
    TimedMode(int maxTime, int value) {
        timeLimit = maxTime;
        answer = value;
    }

    public void run() 
    {
        try {
            long start = System.nanoTime();
            while(timeLimit > 0) {
                long possibleSecond = System.nanoTime();
                if((possibleSecond - (long) 1e9) >= start) {
                    System.out.println("Timer: " + timeLimit);
                    start = possibleSecond;
                    timeLimit--;
                }
            }

            System.out.println("Timelimit Reached! The answer was " + answer);
            System.exit(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
