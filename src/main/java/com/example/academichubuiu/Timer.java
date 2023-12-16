package com.example.academichubuiu;

/**
 * A simple java stopwatch
 */
public class Timer {
    /**
     * Whether the stopwatch is running
     */
    private boolean running;

    /**
     * Whether the Stopwatch has been paused... not actively counting but the start time should be preserved
     */
    private boolean paused;

    /**
     * The start time in microseconds
     */
    private long start;

    /**
     * The Start time for the current paused time
     */
    private long pausedStart;

    /**
     * The end time
     */
    private long end;

    /**
     * Default Constructor
     */
    public Timer() {
        this.pausedStart = 0;
        this.start = 0;
        this.end = 0;
    }

    /**
     * Determines if the Stopwatch is running (could be paused)
     *
     * @return Whether the stopwatch is currently running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Whether this stopwatch is paused
     *
     * @return true if it is currently paused
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * Starts the Stopwatch
     */
    public void start() {
        start = System.nanoTime();
        running = true;
        paused = false;
        pausedStart = -1;
    }

    /**
     * Stops the stopwatch and returns the time elapsed
     *
     * @return Stops the Timer
     */
    public long stop() {
        if (!isRunning()) {
            return -1;
        } else if (isPaused()) {
            running = false;
            paused = false;

            return pausedStart - start;
        } else {
            end = System.nanoTime();
            running = false;
            return end - start;
        }
    }

    /**
     * Pauses the Stopwatch
     *
     * @return The time elapsed so far
     */
    public long pause() {
        if (!isRunning()) {
            return -1;
        } else if (isPaused()) {
            return (pausedStart - start);
        } else {
            pausedStart = System.nanoTime();
            paused = true;
            return (pausedStart - start);
        }
    }

    /**
     * Resumes the Timer from it's paused state
     */
    public void resume() {
        if (isPaused() && isRunning()) {
            start = System.nanoTime() - (pausedStart - start);
            paused = false;
        }
    }

    /**
     * Returns the total time elapsed
     *
     * @return The total time elapsed
     */
    public long elapsed() {
        if (isRunning()) {
            if (isPaused())
                return (pausedStart - start);
            return (System.nanoTime() - start);
        } else
            return (end - start);
    }

    /**
     * Returns the number of seconds this Stopwatch has elapsed
     *
     * @return The String of the number of seconds
     */
    public String toString() {
        long enlapsed = elapsed();
        return ((double) enlapsed / 1000000000.0) + " Seconds";
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
        Thread thread = new Thread(() -> {
            int i = 1;
            while (i <= 10) {
                System.out.println(timer.toString());
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}