package Lects.Lect5;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("1. Hello FROM " + Thread.currentThread().getName());
    }
}
