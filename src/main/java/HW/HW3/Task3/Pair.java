package HW.HW3.Task3;

/**
 * Напишите обобщённый класс Pair, который предстваляет собой пару значений разного типа.
 * Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
 * а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Pair<T, V> {
    private T firstValue;
    private V secondValue;

    public Pair(T firstValue, V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    public T getFirst(){
        return firstValue;
    }
    public V getSecond(){
        return secondValue;
    }

    @Override
    public String toString() {
        return "Pair: " + firstValue + ", " + secondValue;
    }

    public static void main(String[] args) {
        Pair pair = new Pair(1, 2.5f);
        System.out.println(pair);

        Pair pair1 = new Pair(1, "Nothing");
        System.out.println(pair1);

        Pair pair2 = new Pair("Hello", "WORLD");
        System.out.println(pair2);
    }
}
