package HW.HW5;

import java.util.ArrayList;
import java.util.List;

/**
 * Пять безмолвных философов  сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
 * Вилки лежат на столе между каждой парой ближайших философов.
 * Каждый философ может либо есть, либо размышлять
 * Философ может есть только тогда, когда держит две вилки - Взятую слева и справа
 * Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
 * Можно брать только две вилки одновременно.
 * Описать в виде кода такую ситуацию - Каждый философ должен поесть три раза
 */
public class Main {
    public static void main(String[] args) {
        List<Philosopher> philosophers = new ArrayList<>();
        List<Fork> forks = new ArrayList<>();

        // Количество философов и вилок
        int count = 5;

        for (int i = 0; i < count; i++)
            forks.add(new Fork());

        for (int i = 0; i < count; i++) {
            Fork leftFork = forks.get(i);
            Fork rightFork = forks.get((i + 1) % count);

            philosophers.add(new Philosopher(i, leftFork, rightFork));
            philosophers.get(i).start();
        }

        for (Philosopher philosopher : philosophers){
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ALL PHILOSOPHERS POKUSHALI!" );
    }
}
