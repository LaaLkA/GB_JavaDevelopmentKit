package Sems.Sem3.Fruits;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();

        fruitBox.add(new Orange());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
//        appleBox.add(new Apple());

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println(appleBox.compare(orangeBox));
        appleBox.transferTo(fruitBox);
        System.out.println(fruitBox);
    }


}
