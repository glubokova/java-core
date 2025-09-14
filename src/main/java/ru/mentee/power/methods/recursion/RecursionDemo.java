package ru.mentee.power.methods.recursion;

import java.util.Arrays;

public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println("=== Факториал ===");
        System.out.println("5! = " + RecursionExercises.factorial(5));
        System.out.println("10! = " + RecursionExercises.factorial(10));

        System.out.println("\n=== Числа Фибоначчи ===");
        System.out.println("Наивная реализация:");
        for (int i = 0; i <= 10; i++) {
            System.out.print(RecursionExercises.fibonacci(i) + " ");
        }

        System.out.println("\nОптимизированная реализация:");
        for (int i = 0; i <= 10; i++) {
            System.out.print(RecursionExercises.fibonacciOptimized(i) + " ");
        }

        System.out.println("\n\n=== Проверка палиндрома ===");
        String[] testStrings = {
                "",
                "a",
                "racecar",
                "Madam",
                "А роза упала на лапу Азора",
                "hello",
                "not a palindrome",
                "level"
        };

        for (String str : testStrings) {
            boolean isPal = RecursionExercises.issPalindrome(str);
            System.out.println("'" + str + "' -> " + (isPal ? "Палиндром" : "Не палиндром"));
        }

        System.out.println("\n=== Сумма цифр ===");
        int number = 12345;
        int sum = RecursionExercises.sumOfDigits(number);
        System.out.println("Сумма цифр числа " + number + " = " + sum);

        System.out.println("\n=== Возведение в степень ===");
        double base = 2;
        int exponent1 = 10;
        int exponent2 = -3;
        double result1 = RecursionExercises.power(base, exponent1);
        double result2 = RecursionExercises.power(base, exponent2);
        System.out.println(base + "^" + exponent1 + " = " + result1);
        System.out.println(base + "^" + exponent2 + " = " + result2);

        System.out.println("\n=== Наибольший общий делитель ===");
        int a = 48;
        int b = 36;
        int gcdResult = RecursionExercises.gcd(a, b);
        System.out.println("НОД(" + a + ", " + b + ") = " + gcdResult);

        System.out.println("\n=== Обращение массива ===");
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        RecursionExercises.reverseArray(array, 0, array.length - 1);
        System.out.println("Обращенный массив: " + Arrays.toString(array));
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\nЧастичное обращение:");
        System.out.println("Исходный массив: " + Arrays.toString(array2));
        RecursionExercises.reverseArray(array2, 2, 5);
        System.out.println("После обращения элементов 2-5: " + Arrays.toString(array2));
    }
}