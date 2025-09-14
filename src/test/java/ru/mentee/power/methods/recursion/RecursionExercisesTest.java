package ru.mentee.power.methods.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecursionExercisesTest {

    @Test
    public void testFactorial() {
        assertEquals(1, RecursionExercises.factorial(0));
        assertEquals(1, RecursionExercises.factorial(1));
        assertEquals(2, RecursionExercises.factorial(2));
        assertEquals(6, RecursionExercises.factorial(3));
        assertEquals(120, RecursionExercises.factorial(5));
        assertEquals(3628800, RecursionExercises.factorial(10));

        try {
            RecursionExercises.factorial(-1);
            fail("Expected IllegalArgumentException for negative input");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testFibonacci() {
        assertEquals(0, RecursionExercises.fibonacci(0));
        assertEquals(1, RecursionExercises.fibonacci(1));
        assertEquals(1, RecursionExercises.fibonacci(2));
        assertEquals(2, RecursionExercises.fibonacci(3));
        assertEquals(3, RecursionExercises.fibonacci(4));
        assertEquals(5, RecursionExercises.fibonacci(5));
        assertEquals(8, RecursionExercises.fibonacci(6));
        assertEquals(55, RecursionExercises.fibonacci(10));
        try {
            RecursionExercises.fibonacci(-1);
            fail("Expected IllegalArgumentException for negative input");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testFibonacciOptimized() {
        assertEquals(0, RecursionExercises.fibonacciOptimized(0));
        assertEquals(1, RecursionExercises.fibonacciOptimized(1));
        assertEquals(1, RecursionExercises.fibonacciOptimized(2));
        assertEquals(2, RecursionExercises.fibonacciOptimized(3));
        assertEquals(3, RecursionExercises.fibonacciOptimized(4));
        assertEquals(5, RecursionExercises.fibonacciOptimized(5));
        assertEquals(8, RecursionExercises.fibonacciOptimized(6));
        assertEquals(55, RecursionExercises.fibonacciOptimized(10));
        assertEquals(6765, RecursionExercises.fibonacciOptimized(20));
        assertEquals(832040, RecursionExercises.fibonacciOptimized(30));
        try {
            RecursionExercises.fibonacciOptimized(-10);
            fail("Expected IllegalArgumentException for negative input");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(RecursionExercises.issPalindrome(""));
        assertTrue(RecursionExercises.issPalindrome("a"));
        assertTrue(RecursionExercises.issPalindrome("aa"));
        assertTrue(RecursionExercises.issPalindrome("racecar"));
        assertTrue(RecursionExercises.issPalindrome("level"));
        assertTrue(RecursionExercises.issPalindrome("madam"));
        assertFalse(RecursionExercises.issPalindrome("hello"));
        assertFalse(RecursionExercises.issPalindrome("world"));
        assertFalse(RecursionExercises.issPalindrome("java"));
        assertFalse(RecursionExercises.issPalindrome("programming"));
        assertTrue(RecursionExercises.issPalindrome("A man a plan a canal Panama"));
        assertTrue(RecursionExercises.issPalindrome("Race car"));
        assertFalse(RecursionExercises.issPalindrome(null));
    }

    @Test
    public void testSumOfDigits() {
        assertEquals(0, RecursionExercises.sumOfDigits(0));
        assertEquals(5, RecursionExercises.sumOfDigits(5));
        assertEquals(9, RecursionExercises.sumOfDigits(9));
        assertEquals(6, RecursionExercises.sumOfDigits(123));
        assertEquals(10, RecursionExercises.sumOfDigits(1234));
        assertEquals(15, RecursionExercises.sumOfDigits(12345));
        assertEquals(6, RecursionExercises.sumOfDigits(-123));
    }

    @Test
    public void testPower() {
        assertEquals(1.0, RecursionExercises.power(2, 0), 0.0001);
        assertEquals(2.0, RecursionExercises.power(2, 1), 0.0001);
        assertEquals(4.0, RecursionExercises.power(2, 2), 0.0001);
        assertEquals(8.0, RecursionExercises.power(2, 3), 0.0001);
        assertEquals(16.0, RecursionExercises.power(2, 4), 0.0001);
        assertEquals(1.0, RecursionExercises.power(5, 0), 0.0001);
        assertEquals(5.0, RecursionExercises.power(5, 1), 0.0001);
        assertEquals(25.0, RecursionExercises.power(5, 2), 0.0001);
        assertEquals(0.5, RecursionExercises.power(2, -1), 0.0001);
        assertEquals(0.25, RecursionExercises.power(2, -2), 0.0001);
        assertEquals(0.2, RecursionExercises.power(5, -1), 0.0001);
        assertEquals(0.04, RecursionExercises.power(5, -2), 0.0001);
        assertEquals(0.0, RecursionExercises.power(0, 5), 0.0001);
        assertEquals(1.0, RecursionExercises.power(0, 0), 0.0001);
    }

    @Test
    public void testGcd() {
        assertEquals(1, RecursionExercises.gcd(1, 1));
        assertEquals(1, RecursionExercises.gcd(2, 3));
        assertEquals(2, RecursionExercises.gcd(2, 4));
        assertEquals(2, RecursionExercises.gcd(4, 6));
        assertEquals(3, RecursionExercises.gcd(3, 9));
        assertEquals(6, RecursionExercises.gcd(12, 18));
        assertEquals(1, RecursionExercises.gcd(17, 13));
        assertEquals(12, RecursionExercises.gcd(36, 48));
        assertEquals(12, RecursionExercises.gcd(48, 36));
        assertEquals(6, RecursionExercises.gcd(-12, 18));
        assertEquals(6, RecursionExercises.gcd(12, -18));
        assertEquals(5, RecursionExercises.gcd(0, 5));
        assertEquals(5, RecursionExercises.gcd(5, 0));
        assertEquals(0, RecursionExercises.gcd(0, 0));
    }

    @Test
    public void testReverseArray() {
        int[] array1 = {1};
        RecursionExercises.reverseArray(array1, 0, array1.length - 1);
        assertArrayEquals(new int[]{1}, array1);

        int[] array2 = {1, 2};
        RecursionExercises.reverseArray(array2, 0, array2.length - 1);
        assertArrayEquals(new int[]{2, 1}, array2);

        int[] array3 = {1, 2, 3};
        RecursionExercises.reverseArray(array3, 0, array3.length - 1);
        assertArrayEquals(new int[]{3, 2, 1}, array3);

        int[] array4 = {1, 2, 3, 4, 5};
        RecursionExercises.reverseArray(array4, 0, array4.length - 1);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, array4);
        int[] array5 = {1, 2, 3, 4, 5};
        RecursionExercises.reverseArray(array5, 1, 3);
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, array5);
        int[] array6 = {};
        RecursionExercises.reverseArray(array6, 0, array6.length - 1);
        assertArrayEquals(new int[]{}, array6);
    }
}