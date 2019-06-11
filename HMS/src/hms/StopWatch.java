package hms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suson
 */
public class StopWatch {
// instance varibale

    private final long start;
    private long stop;

    /**
     * Constructor of stopwatch class which starts the clock for benchmarking
     */
    public StopWatch() {
        this.start = System.currentTimeMillis();
    }

    /**
     * This method stops the time
     */
    public void stop() {
        this.stop = System.currentTimeMillis();
    }

    /**
     * This method returns the amount of time elapses while benchmarking
     *
     * @return the time spent
     */
    public long timeElapsed() {
        // can also divide by 1000 to get this into seconds :D
        return stop - start;
    }

}
