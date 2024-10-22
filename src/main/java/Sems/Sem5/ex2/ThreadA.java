package Sems.Sem5.ex2;

public class ThreadA implements Runnable {
    private volatile Boolean switcher = false;

    public boolean getSwitcher() {
        return switcher;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                switcher = !(switcher);
                System.out.println("Switcher switched: now - " + switcher);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
