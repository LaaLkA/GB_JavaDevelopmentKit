package Lects.Lect5.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Show  - CurrentModificationException
 */
public class CME {
    /*public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Runnable r1 = () -> {
            for (int i = 0; i < 100; i++) {
                synchronized (list) {
                    list.add(i);
                }
            }
        };
        Runnable r2 = () -> {
            synchronized (list) {
                for (Integer value : list) {
                    System.out.printf("%s ", value);
                }
            }
            System.out.println();
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }*/


    /*
     * Без синхронизации
     */

    // CopyOnWriteArrayList<>()
    /*public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        Runnable r1 = () -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        };
        Runnable r2 = () -> {
            for (Integer value : list) {
                System.out.printf("%s ", value);
            }
            System.out.println();
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }*/

    // ConcurrentLinkedDeque<>()
    public static void main(String[] args) {
        Queue<Integer> list = new ConcurrentLinkedDeque<>();
        Runnable r1 = () -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        };
        Runnable r2 = () -> {
            for (Integer value : list) {
                System.out.printf("%s ", value);
            }
            System.out.println();
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }

}
