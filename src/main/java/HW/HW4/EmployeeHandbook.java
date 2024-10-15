package HW.HW4;

import java.util.*;

public class EmployeeHandbook {
    List<Employee> employees = new ArrayList<>();

    public void addEmp(String name, int tabNumber, int phoneNumber, int experience) {
        employees.add(new Employee(name, tabNumber, phoneNumber, experience));
    }

    public void addEmp(Employee emp) {
        employees.add(emp);
    }

    public List<Employee> findByExperience(int experience) {
//        List<String> res = new ArrayList<>();
//        for (Employee emp : employees) {
//            if (emp.getExperience() == experience)
//                res.add(emp.getName());
//        }
//        Collections.sort(res);
//        System.out.printf("Have been found by the experience is %s\n", experience);
//        for (String name : res) {
//            System.out.println(name);
//        }
        List<Employee> res = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getExperience() == experience) {
                res.add(e);
            }
        }
        return res;
    }

    public List<Employee> findNumberByName(String name) {
        List<Employee> res = new ArrayList<>();
//        System.out.printf("Have been found by the name of %s :\n", name);
        for (Employee emp : employees) {
            if (Objects.equals(emp.getName(), name)) {
//                System.out.printf("TabNumber: %s, Name: %s, Phone number: %s\n",
//                        emp.getTabNumber(), emp.getName(),emp.getPhoneNumber());
                res.add(emp);
            }
        }
        return res;
    }

    public List<Employee> findEmployeeByTabNumber(int tabNumber) {
//        System.out.printf("Have been found by the tab number %d :\n", tabNumber);
        List<Employee> res = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getTabNumber() == tabNumber) {
//                System.out.printf("TabNumber: %s, Name: %s, PhoneNumber: %s, Experience: %s\n",
//                        emp.getTabNumber(), emp.getName(), emp.getPhoneNumber(), emp.getExperience());
                res.add(emp);
            }
        }
        return res;
    }
}
