package Lects.Lect5.thread;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    private int value;
    private CountDownLatch cdl;

    public Task(int value) {
        this.value = value;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void inc(){
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            inc();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
