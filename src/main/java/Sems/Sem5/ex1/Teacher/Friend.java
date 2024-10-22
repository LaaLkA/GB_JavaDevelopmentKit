package Sems.Sem5.ex1.Teacher;

public class Friend {

    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public synchronized void bow(Friend friend){
        System.out.println(name + ": " + friend.getName() + " bowed me");
        friend.bowBack(this);
    }

    private synchronized void bowBack(Friend friend) {
        System.out.println(name + ": bowed v otvet " + friend.getName());
    }
}
