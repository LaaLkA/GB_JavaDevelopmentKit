package Sems.Sem4.Ex1;

import java.util.*;

/**
 * Срздайте коллекцию мужских имен и женских имен с помощью интерфейсов List
 * Отсортируйте коллекцию в алфавитном порядке
 * Отсортируйте коллекцию по количеству букв в слове
 * Разверните колекцию
 */
public class Program {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Александр", "Сергей", "Ирина", "Светлана"));
        System.out.println(names);
        sortByAlphabet(names);
        System.out.println(names);
        sortByLength(names);
        System.out.println(names);
        revers(names);
        System.out.println(names);
    }

    public static void sortByAlphabet(List<String> names) {
        Collections.sort(names);
    }

    public static void sortByLength(List<String> names) {
        names.sort(Comparator.comparing(String::length));
    }

    public static void revers(List<String> names) {
        Collections.reverse(names);
    }

}
