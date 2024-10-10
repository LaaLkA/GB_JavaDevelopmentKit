package Sems.Sem3.Fruits;

public class Orange implements Fruit{
    public static final float weight = 1.0f;
    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange";
    }
}
