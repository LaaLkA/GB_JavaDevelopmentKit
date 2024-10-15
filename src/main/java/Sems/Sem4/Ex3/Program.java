package Sems.Sem4.Ex3;

import java.util.HashMap;
import java.util.Map;

/**
 * Создайте телефонный справочник с помощью Map - телефон это ключ, а имя - это значение
 * Найдите человека с самым маленьким номером телефона
 * Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class Program {
    public static void main(String[] args) {
        Map<String,String> phonebook = new HashMap<>();
        phonebook.put("8987", "Иван");
        phonebook.put("+7-900-900-80-80", "Иван");
        phonebook.put("+7-900-900-90-80", "Иван");
        phonebook.put("+7-900-900-70-80", "Иван");
    }
}
