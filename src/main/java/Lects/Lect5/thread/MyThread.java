package Lects.Lect5.thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("1. Hello FROM " + Thread.currentThread().getName());
    }
}
