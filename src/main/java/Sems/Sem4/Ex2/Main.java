package Sems.Sem4.Ex2;

import java.util.*;

/**
 * Создайте коллекцию мужских имен и женских имен с помощью интерфейсов List - добавьте дубликаты
 * Получите уникальный список Set на основе List
 * Определите наименьший элемент (алфавитный порядок)
 * Определите наибольший элемент (по количеству букв в слове, но в обратном порядке)
 * Удалите все элементы, содержащие букву "А"
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                Arrays.asList("Иван", "Александр", "Сергей", "Ирина", "Светлана", "Светлана"));

        Set<String> uniqueNames = convertListToSet(names);
        minLength(uniqueNames);
        minmaxLength(uniqueNames);
        deleteNamesByChar(uniqueNames, 'а');
        System.out.println(uniqueNames);
    }

    public static Set<String> convertListToSet(List<String> names) {
        return new HashSet<>(names);
    }

    public static void minLength(Set<String> names) {
        System.out.println("Наименьший элемент: " + names.stream().min(Comparator.naturalOrder()).orElse(null));
    }

    public static void minmaxLength(Set<String> names) {
        String minElement = names.stream().min(Comparator.comparingInt(String::length)).orElse(null);
        String maxElement = names.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("min - max: " + minElement + " " + maxElement);
    }

    public static void deleteNamesByChar(Set<String> names, char symbol) {
        names.removeIf(name -> name.toLowerCase().contains(String.valueOf(symbol).toLowerCase()));
    }
}
