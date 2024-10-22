package Sems.Sem5.ex3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread {
    private String name;
    private CountDownLatch startSignal, readySignal, finishSignal;

    public Runner(String name, CountDownLatch startSignal, CountDownLatch finishSignal, CountDownLatch readySignal) {
        this.name = name;
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
        this.readySignal = readySignal;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000,3000));
            System.out.println("Runner " + name + " on start point!");
            readySignal.countDown();
            startSignal.await();
            System.out.println("Runner " + name + " started");
            Thread.sleep(new Random().nextInt(100,500));
            System.out.println("Runner " + name + " on finish point");
            finishSignal.countDown();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
