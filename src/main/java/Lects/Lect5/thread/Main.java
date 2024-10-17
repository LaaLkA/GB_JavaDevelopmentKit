package Lects.Lect5.thread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 3; i++) {
            new MyThread().start();
        }
        System.out.println("\n");
        for (int i = 0; i < 5; i++) {
            new Thread((new MyRunnable())).start();
        }

        for (int i = 0; i < 3; i++) {
            
        }
    }
}
