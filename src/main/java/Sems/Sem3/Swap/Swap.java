package Sems.Sem3.Swap;

import java.util.Arrays;

public class Swap {
    private static void swap(Object[] array, int from , int to) {
        Object temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public static void main(String[] args) {
        Object[] array = {1, 2.0f, "hello"};
        System.out.println(Arrays.toString(array));
        swap(array, 0, 2);
        System.out.println(Arrays.toString(array));
    }
}
