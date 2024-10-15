package Sems.Sem4.Ex3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Создайте телефонный справочник с помощью Map - телефон это ключ, а имя - это значение
 * Найдите человека с самым маленьким номером телефона
 * Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class Program {
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("89871033770", "Ivan");
        phonebook.put("89871033740", "Boris");
        phonebook.put("89871033750", "Anna");
        phonebook.put("89871033760", "superJulia");

        System.out.println(findByMinProneNumber(phonebook));
        System.out.println(findByMaxAlphabetName(phonebook));
    }

    public static String findByMinProneNumber(Map<String, String> phonebook) {
        Set<Long> numbers = phonebook.keySet().stream().map(el -> Long.valueOf(el)).collect(Collectors.toSet());
        long resNumber = numbers.stream().min(Comparator.naturalOrder()).get();
        return String.format("Smallest number: %s, Owner of the phone number: %s",
                resNumber, phonebook.get(String.valueOf(resNumber)));
    }

    public static String findByMaxAlphabetName(Map<String, String> phonebook) {
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
        Map.Entry<String, String> name = elements.stream().max((entry1, entry2) ->
                entry1.getValue().compareTo(entry2.getValue())).get();
        return String.format("Max alphabet name is: %s", name.getValue());
    }
}
