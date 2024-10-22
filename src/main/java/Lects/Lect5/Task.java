package Lects.Lect5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
    private final AtomicInteger value;
    private CountDownLatch cdl;

    public Task(int value) {
        this.value = new AtomicInteger(value);
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void inc() {
//        synchronized (Task.class){
//            value++;
//        }
        value.incrementAndGet();
    }

    public int getValue() {
//        return value;
        return value.intValue();
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
