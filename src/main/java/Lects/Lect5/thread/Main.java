package Lects.Lect5.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 3; i++) {
            // 2
            Thread thread = new MyThread();
            thread.start();
            thread.join();
        }

        for (int i = 0; i < 5; i++) {
            // 1
            Thread thread = new Thread((new MyRunnable()));
            thread.start();
            thread.join();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("3. Hello FROM " + Thread.currentThread().getName());
            }).start();
        }
    }
}
