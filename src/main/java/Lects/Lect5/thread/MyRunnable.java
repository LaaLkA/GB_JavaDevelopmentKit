package Lects.Lect5.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello FROM " + Thread.currentThread().getName());
    }

}
