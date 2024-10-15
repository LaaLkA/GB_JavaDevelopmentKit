package HW.HW4;

public class Employee {
    private String name;
    private int tabNumber;
    private int phoneNumber;
    private int experience;

    public Employee(String name, int tabNumber, int phoneNumber, int experience) {
        this.name = name;
        this.tabNumber = tabNumber;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTabNumber() {
        return tabNumber;
    }

    public void setTabNumber(int tabNumber) {
        this.tabNumber = tabNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", tabNumber, name, phoneNumber, experience);
    }
}
