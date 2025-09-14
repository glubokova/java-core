package ru.mentee.power.methods.recursion;

import java.util.HashMap;
import java.util.Map;

public class RecursionExercises {
    private static Map<Integer, Long> fibonacciCache = new HashMap<>();

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n не может быть отрицательным");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n не может быть отрицательным");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacciOptimized(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n не может быть отрицательным");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        long prev1 = 0;
        long prev2 = 1;
        long result = 0;

        for (int i = 2; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }

    public static boolean issPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }

    private static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static int sumOfDigits(int n) {
        int absN = Math.abs(n);
        if (absN < 10) {
            return absN;
        }
        return (absN % 10) + sumOfDigits(absN / 10);
    }

    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        if (exponent % 2 == 0) {
            double halfPower = power(base, exponent / 2);
            return halfPower * halfPower;
        } else {
            return base * power(base, exponent - 1);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static void reverseArray(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        reverseArray(array, start + 1, end - 1);
    }
}