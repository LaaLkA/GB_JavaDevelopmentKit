package Lects.Lect5.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("2. Hello FROM " + Thread.currentThread().getName());
    }

}
