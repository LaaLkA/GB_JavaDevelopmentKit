package Sems.Sem3.Ex2;

import java.util.Arrays;

/**
 * Описать собственную коллекцию - список на основе массива
 * Каллекция должна иметь возможность хранить любые типы данныз, иметь методы добавления и удаления элементов.
 */
public class Program<T> {
    private Object[] array;
    private int size;

    public Program(int size) {
        this.array = new Object[size];
    }

    public void add(T element) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = element;
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
    }

}
