package HW.HW4;

/**
 * Создать класс справочник сотрудников, который содержит внутри:
 * Коллекию сотрудников - каждый сотрудник дожен иметь следующие атрибуты:
 * Табельный номер;
 * Номер телефона;
 * Имя;
 * Стаж.
 * Добавить метод, который ищет сотрудника по стажу (может быть список);
 * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список);
 * Добавить метод, который ищет сотрудника по табельному номеру;
 * Добавить метод добавления нвоого сотрудника в справочник.
 */

public class Main {
    public static void main(String[] args) {
        try{
            EmployeeHandbook handbook = new EmployeeHandbook();
            handbook.addEmp(new Employee("Nick", 1, 12345, 1));
            handbook.addEmp(new Employee("Julia", 2, 23456, 9));
            handbook.addEmp(new Employee("Buddy", 3, 34567, 6));
            handbook.addEmp(new Employee("Lonny", 4, 45678, 12));

            System.out.printf("Found employees by experience (12): \n %s \n", handbook.findByExperience(12));
            System.out.printf("Found phone numbers by name (Julia): \n %s \n", handbook.findNumberByName("Julia"));
            System.out.printf("Found employees by tab number: \n %s \n", handbook.findEmployeeByTabNumber(1));

            System.out.println("\n-" +
                    "\n--" +
                    "\n---" +
                    "\n __LITTLE TEST__");
            handbook.addEmp(new Employee("Lonny", 4, 45678, 12));
            handbook.addEmp(new Employee("Lonny", 4, 45678, 12));
            handbook.addEmp(new Employee("Lonny", 4, 45678, 12));
            handbook.addEmp(new Employee("Buddy", 3, 34567, 6));
            handbook.addEmp(new Employee("Buddy", 3, 34567, 6));
            handbook.addEmp(new Employee("Julia", 2, 23456, 9));

            System.out.printf("Found employees by experience (12): \n %s \n", handbook.findByExperience(12));
            System.out.printf("Found phone numbers by name (Julia): \n %s \n", handbook.findNumberByName("Julia"));
            System.out.printf("Found employees by tab number: \n %s \n", handbook.findEmployeeByTabNumber(1));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
