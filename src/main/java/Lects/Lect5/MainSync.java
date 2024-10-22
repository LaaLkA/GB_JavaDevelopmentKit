package Lects.Lect5;

import java.util.concurrent.CountDownLatch;

public class MainSync {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task(0);
        CountDownLatch cdl = new CountDownLatch(3);
        task.setCdl(cdl);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
        cdl.await();
        System.out.println(task.getValue());
    }
}
