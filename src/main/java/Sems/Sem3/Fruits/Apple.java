package Sems.Sem3.Fruits;

public class Apple implements Fruit {
    private static final float weight = 1.5f;

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
