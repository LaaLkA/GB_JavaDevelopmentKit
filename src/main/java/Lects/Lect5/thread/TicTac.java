package Lects.Lect5.thread;

public class TicTac implements Runnable {
    private String bracket;

    public TicTac(String bracket) {
        this.bracket = bracket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(bracket);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
//        tac.setDaemon(true);
//        tic.setDaemon(true);
        tic.start();
        tac.start();
    }
}
