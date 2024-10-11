package Sems.Sem3.Ex3;

import java.util.Iterator;
import java.util.List;

/**
 * Написать итератор по массиву. Итератор - это объект, осуществляющий движение по коллекциям любого типа,
 * собержащим любые типы данных. Итераторы обычно имеют только два метода - проверка на наличие
 * следующего элемента и переход к следующему жлементу. Но также, особенно в других языках программирования,
 * возможно встретить итераторы, реализующие дополнительную логику.
 */
public class GenericIterator <T> implements Iterator {
    private List<T> list;
    private int index;

    public GenericIterator(List<T> list) {
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Object next() {
        return list.get(index++);
    }

    @Override
    public void remove() {
        list.remove(index - 1);
    }
}
