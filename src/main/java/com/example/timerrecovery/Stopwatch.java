/**
 * Stopwatch class that keeps track of time elapsed
 * and can be paused, stopped, started, and reset.
 *
 * @author Nicholas Bogan
 */
public class Stopwatch {
    private long storedTime;
    private long elapsedTime;
    private long startTime;
    private boolean running;
    private boolean paused;

    public long getTime() {
        return storedTime + elapsedTime;
    }
    public Stopwatch() {
        running = false;
        elapsedTime = 0;
        startTime = System.currentTimeMillis();
        storedTime = 0;
    }

    public boolean isRunning() {
        return running;
    }

    public void pause() {
        paused = !paused;
        if (running && !paused) {
            this.stop();
            this.start();
        }
    }

    public void stop() {
        running = false;
    }

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
            Thread thread = new Thread(() -> {
                while(running && !paused) {
                    elapsedTime = System.currentTimeMillis() - startTime;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                storedTime += System.currentTimeMillis() - startTime;
                elapsedTime = 0;
            });
            thread.start();
        }
    }
    
    public void reset() {
        elapsedTime = 0;
        storedTime = 0;
        startTime = System.currentTimeMillis();
    }

    public String toString() {
        return String.format("%d:%02d:%02d", (storedTime + elapsedTime) / 1000 / 60 / 60, (storedTime + elapsedTime) / 1000 / 60 % 60, (storedTime + elapsedTime) / 1000 % 60);
    }
}
