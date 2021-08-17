package Lesson02;

public class HomeWorkApp {
    public static void main(String[] args){
        System.out.println("Task 1:");
        System.out.println(methodFirst(10, 1));
        System.out.println();
        System.out.println("Task 2:");
        methodSecond(0);
        System.out.println();
        System.out.println("Task 3:");
        System.out.println(methodThird(0));
        System.out.println();
        System.out.println("Task 4:");
        methodFour("Hello!", 5);
        System.out.println();
        System.out.println("Task 5*:");
        System.out.println(methodFive(2021));
        System.out.println();
    }
    /**
     * Задание 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
     * от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    public static boolean methodFirst(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }
    /**
     * Задание 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     * положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void methodSecond(int x) {
        if (x >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }
    /**
     * Задание 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
     * если число отрицательное, и вернуть false если положительное.
     */
    public static boolean methodThird(int y) {
        return y < 0;
    }
    /**
     * Задание 4. Написать метод, которому в качестве аргументов передается строка и число,
     * метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    public static void methodFour(String fraza, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(fraza);
        }
    }
    /**
     * Задание 5. * Написать метод, который определяет, является ли год високосным,
     * и возвращает boolean (високосный - true, не високосный - false).
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean methodFive(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }
}
