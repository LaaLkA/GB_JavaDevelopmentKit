package HW.HW3.Task1;

/**
 * Написать класс Калькулятор(необобщённый), который содержит обобщенные статические методы:
 * sum(), multiply(), divide(), subtract(). Параметры этих методов - два числа разного типа,
 * над которыми должна быть произведена операция.
 */
public class Calculator {

    public static <T extends Number> double sum(T number1, T number2){
        return number1.doubleValue() + number2.doubleValue();
    }

    public static <T extends Number> double subtract(T number1, T number2){
        return number1.doubleValue() - number2.doubleValue();
    }

    public static <T extends Number> double multiply(T number1, T number2){
        return number1.doubleValue() * number2.doubleValue();
    }

    public static <T extends Number> double divide(T number1, T number2){
        return number1.doubleValue() / number2.doubleValue();
    }

    public static void main(String[] args) {
        System.out.printf("\nSUMS" +
                "\nIntegers: 10 + 20 = " + sum(10,20) +
                "\nFloats: 10.5 + 20.6 = " + sum(10.5f,20.6f));
        System.out.printf("\nSUBTRACT" +
                "\nIntegers: 40 - 20 = " + subtract(40,20) +
                "\nFloats: 30.5 - 20.6 = " + subtract(30.5f,20.6f));
        System.out.printf("\nMULTIPLY" +
                "\nIntegers: 10 * 20 = " + multiply(10,20) +
                "\nFloats: 10.5 * 20.6 = " + multiply(10.5f,20.6f));
        System.out.printf("\nDIVIDE" +
                "\nIntegers: 20/10 = " + divide(20,10) +
                "\nFloats: 31.6/2.0 = " + divide(31.6f,2.0f));
    }

}
