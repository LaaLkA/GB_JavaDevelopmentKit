package Sems.Sem3.Fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> container;

    Box() {
        container = new ArrayList<>();
    }

    void add(T fruit) {
        container.add(fruit);
    }

    void print() {
        System.out.println(getWeight());
    }

    public T get(int index) {
        return container.get(index);
    }

    float getWeight() {
        return container.get(0).getWeight() * container.size();
    }

    boolean compare(Box<?> with) {
        return getWeight() == with.getWeight();
    }

    void transferTo(Box<? super T> dest) {
        dest.container.addAll(container);
        this.container.clear();
    }

    @Override
    public String toString() {
        return container.toString();
    }
}
