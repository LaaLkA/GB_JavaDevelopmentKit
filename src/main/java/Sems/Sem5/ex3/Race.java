package Sems.Sem5.ex3;

import java.util.concurrent.CountDownLatch;

public class Race extends Thread {
    private CountDownLatch startSignal, readySignal, finishSignal;

    public Race(CountDownLatch startSignal, CountDownLatch finishSignal, CountDownLatch readySignal) {
        this.startSignal = startSignal;
        this.readySignal = readySignal;
        this.finishSignal = finishSignal;
    }

    @Override
    public void run() {
        try {
            readySignal.await();
            System.out.println("Na Start!");
            sleep(100);
            System.out.println("Vnimanie!");
            sleep(100);
            System.out.println("MARSH!");
            startSignal.countDown();
            finishSignal.await();
            System.out.println("Race end!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
