package Sems.Sem5.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * В рамках выполнения задачи необходимо:
 * 3 бегуна должны прийти к старту гонки
 * Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
 * Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * Программа должна завершиться когда все участники закончат гонку.
 * Подумайте об использовании примитива синхронизации
 */
public class Main {
    private static final int COUNT_RUNNERS = 3;

    public static void main(String[] args) {
        CountDownLatch startSignal = new CountDownLatch(COUNT_RUNNERS);
        CountDownLatch readySignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(COUNT_RUNNERS);

        List<Runner> runners = new ArrayList<>(Arrays.asList(
                new Runner("Vasya", startSignal, finishSignal, readySignal),
                new Runner("Petya", startSignal, finishSignal, readySignal),
                new Runner("Vanya", startSignal, finishSignal, readySignal)
        ));

        Race race = new Race(startSignal, finishSignal, readySignal);
        race.start();
        for (Runner runner : runners){
            runner.start();
        }
    }

}
