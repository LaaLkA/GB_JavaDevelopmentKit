package Sems.Sem5.ex3.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread {
    private List<Runner> runners;
    private CountDownLatch cdl;

    public Race() {
        cdl = new CountDownLatch(3);

        runners = new ArrayList<>(3);
        runners.add(new Runner("Vasya", cdl));
        runners.add(new Runner("Petya", cdl));
        runners.add(new Runner("Semen", cdl));
    }

    @Override
    public void run() {
        try {
            goOnStart();
            cdl.await();
            goAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goAll() throws InterruptedException {
        sleep(1000);
        System.out.println("Na start!");
        sleep(1000);
        System.out.println("Vnimanie!");
        sleep(1000);
        System.out.println("Marsh!");
        for(Runner runner : runners){
            runner.go();
        }
    }

    private void goOnStart() {
        for (Runner runner : runners){
            runner.start();
        }
    }
}
