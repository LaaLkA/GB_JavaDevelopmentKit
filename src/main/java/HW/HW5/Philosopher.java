package HW.HW5;

public class Philosopher extends Thread {
    private final int id;
    private Fork leftFork;
    private Fork rightFork;
    private int meals;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.meals = 3;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking!");
        sleep(1000);
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating!!!");
        meals--;
        sleep(2000);
    }
    private void stopEating() {
        leftFork.putDown();
        rightFork.putDown();
        System.out.println("Philosopher " + id + " PUTDOWN FORKS!!!");
    }

    @Override
    public void run() {
        try {
            while (meals > 0) {
                think();

                if (id % 2 == 0) {
                    leftFork.pickUp();
                    System.out.println("Philosopher " + id + " has taken left FORK !");
                    rightFork.pickUp();
                    System.out.println("Philosopher " + id + " has taken right FORK !");
                } else {
                    rightFork.pickUp();
                    System.out.println("Philosopher " + id + " has taken right FORK !");
                    leftFork.pickUp();
                    System.out.println("Philosopher " + id + " has taken left FORK !");
                }

                eat();
                stopEating();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
