package ru.mentee.power.loop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setExtractBareNamePropertyMethods;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciCalculatorTest {

    private FibonacciCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FibonacciCalculator();
    }

    @Test
    void testFibonacciRecursiveSmallNumbers() {
        assertThat(calculator.fibonacciRecursive(0)).isEqualTo(0);
        assertThat(calculator.fibonacciRecursive(1)).isEqualTo(1);
        assertThat(calculator.fibonacciRecursive(2)).isEqualTo(1);
        assertThat(calculator.fibonacciRecursive(3)).isEqualTo(2);
        assertThat(calculator.fibonacciRecursive(4)).isEqualTo(3);
        assertThat(calculator.fibonacciRecursive(5)).isEqualTo(5);
        assertThat(calculator.fibonacciRecursive(10)).isEqualTo(55);
    }

    @Test
    void testFibnacciIterative() {
        assertThat(calculator.fibonacciIterative(0)).isEqualTo(0);
        assertThat(calculator.fibonacciIterative(1)).isEqualTo(1);
        assertThat(calculator.fibonacciIterative(10)).isEqualTo(55);
        assertThat(calculator.fibonacciIterative(20)).isEqualTo(6765);
        assertThat(calculator.fibonacciIterative(30)).isEqualTo(832040);
        assertThat(calculator.fibonacciIterative(40)).isEqualTo(102334155);
    }

    @Test
    void testFibonacciWithCache() {
        assertThat(calculator.fibonacciWithCache(0)).isEqualTo(0);
        assertThat(calculator.fibonacciWithCache(1)).isEqualTo(1);
        assertThat(calculator.fibonacciWithCache(10)).isEqualTo(55);
        assertThat(calculator.fibonacciWithCache(40)).isEqualTo(102334155);
        assertThat(calculator.fibonacciWithCache(45)).isEqualTo(1134903170);
    }

    @Test
    @Timeout(value = 5)
    void testFibonacciRecursiveWithTimeout() {
        calculator.fibonacciRecursive(25);
    }

    @Test
    void testFibonacciNumber() {
        assertThat(calculator.isFibonacciNumber(0)).isTrue();
        assertThat(calculator.isFibonacciNumber(1)).isTrue();
        assertThat(calculator.isFibonacciNumber(2)).isTrue();
        assertThat(calculator.isFibonacciNumber(3)).isTrue();
        assertThat(calculator.isFibonacciNumber(4)).isFalse();
        assertThat(calculator.isFibonacciNumber(5)).isTrue();
        assertThat(calculator.isFibonacciNumber(6)).isFalse();
        assertThat(calculator.isFibonacciNumber(8)).isTrue();
        assertThat(calculator.isFibonacciNumber(10)).isFalse();
        assertThat(calculator.isFibonacciNumber(13)).isTrue();
        assertThat(calculator.isFibonacciNumber(21)).isTrue();
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> calculator.fibonacciRecursive(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.fibonacciIterative(-5));
        assertThrows(IllegalArgumentException.class, () -> calculator.fibonacciWithCache(-10));
        assertThrows(IllegalArgumentException.class, () -> calculator.generateFibonacciSequence(-3));
        assertThat(calculator.isFibonacciNumber(-1)).isFalse();
        assertThat(calculator.isFibonacciNumber(-5)).isFalse();
    }

    @Test
    void testPerformanceComparison() {
        long startTime, endTime;

        startTime = System.nanoTime();
        long iterativeResult = calculator.fibonacciIterative(40);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        calculator = new FibonacciCalculator();
        startTime = System.nanoTime();
        long cacheResult = calculator.fibonacciWithCache(40);
        endTime = System.nanoTime();
        long cacheTime = endTime - startTime;

        startTime = System.nanoTime();
        long recursiveResult = calculator.fibonacciRecursive(25);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        assertThat(iterativeResult).isEqualTo(cacheResult);
        assertThat(iterativeResult).isEqualTo(102334155L);
        System.out.println("Время выполнения (нс):");
        System.out.println("Итеративный (n=40): " + iterativeTime);
        System.out.println("С кэшированием (n=40): " + cacheTime);
        System.out.println("Рекурсивный (n=25): " + recursiveTime);
    }
}