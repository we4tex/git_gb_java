package Lesson03;

import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args){
        System.out.println("Task 1:");
        int[] array01 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray01("> Было\t", array01);
        change(array01);
        printArray01("> Стало\t", array01);
        System.out.println();
        System.out.println("Task 2:");
        int[] array02 = new int[100];
        fillIn(array02);
        printArray01("> Вывод\t", array02);
        System.out.println();
        System.out.println("Task 3:");
        int[] array03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray01("> Было\t", array03);
        doubling(array03);
        printArray01("> Стало\t", array03);
        System.out.println();
        System.out.println("Task 4:");
        createArray04(5);
        System.out.println();
        System.out.println("Task 5:");
        int[] returnArrayFromMethod = returnArray(10, 100);
        printArray01("> Вывод", returnArrayFromMethod);
}
    /**
     * Урок 3. Практика
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     * 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
     * цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
     * то есть [0][0], [1][1], [2][2], …, [n][n];
     * 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
     * типа int длиной len, каждая ячейка которого равна initialValue;
     */
    public static void printArray01(String msg, int[] inputArray) {
        System.out.print(msg + ": ");
        for (int j : inputArray) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void change(int[] array01) {
        for (int i = 0; i < array01.length; i++)
            if (array01[i] == 1) {
                array01[i] = 0;
            } else {
                array01[i] = 1;
            }
    }
    public static void fillIn(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
    }
    public static void doubling(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;
    }
    public static void createArray04(int size){
        int[][] sqrArray = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sqrArray[i][j] = (i == j || j == (size - i - 1))? 1 : (0);
                System.out.printf("%4d", sqrArray[i][j]);
            }
            System.out.println();
        }
    }
    public static int[] returnArray(int len, int initValue) {
        int[] tempArray = new int[len];
        Arrays.fill(tempArray, initValue);
        return tempArray;
    }
}
