package Sems.Sem5.ex2;

public class ThreadB implements Runnable {
    private int counter = 100;
    private ThreadA threadA;

    public ThreadB(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        while (counter > -1) {
            if (threadA.getSwitcher()) {
                try {
                    Thread.sleep(100);
                    System.out.println(counter--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
