package HW.HW3.Task2;

/**
 * Напишите обобщённый метод CompareArrays(), который принимает два массива и возвращает true,
 * если они одинаковые, и false в проитвном случае.
 * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */
public class Main {
    public static void main(String[] args) {
        Cat[] cats1 = new Cat[10];
        Cat[] cats2 = new Cat[10];
        Dog[] dogs = new Dog[10];
        for (int i = 0; i < 10; i++) {
            cats1[i] = new Cat();
            cats2[i] = new Cat();
            dogs[i] = new Dog();
        }
        try {
            System.out.println(CompareArrays(cats1, dogs));
            System.out.println(CompareArrays(cats1, cats2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T, V> boolean CompareArrays(T[] a, V[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (!a[i].getClass().getName().equals(b[j].getClass().getName())) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}

class Cat{

}
class Dog {

}
