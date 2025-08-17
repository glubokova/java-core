package ru.mentee.power.loop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    @Test
    public void testFizzBuzzForFirst15Numbers() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(15);
        assertThat(result).isNotNull();
        assertThat(result).hasSize(15);
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("Fizz");
        assertThat(result[4]).isEqualTo("Buzz");
        assertThat(result[14]).isEqualTo("FizzBuzz");
    }

    @Test
    public void testFizzBuzzWithZeroInput() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(0);
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
    }

    @Test
    public void testAllFizzValuesAreDivisibleBy3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(100);
        for (int i = 0; i < result.length; i++) {
            if ("Fizz".equals(result[i])) {
                assertThat((i + 1) % 3).isZero();
                assertThat((i + 1) % 5).isNotZero();
            }
        }
    }

    @Test
    public void testAllBuzzValuesAreDivisibleBy5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(100);
        for (int i = 0; i < result.length; i++) {
            if ("Buzz".equals(result[i])) {
                assertThat((i + 1) % 5).isZero();
                assertThat((i + 1) % 3).isNotZero();
            }
        }
    }

    @Test
    public void testAllFizzBuzzValuesAreDivisibleBy3And5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.generateFizzBuzz(100);
        for (int i = 0; i < result.length; i++) {
            if ("FizzBuzz".equals(result[i])) {
                assertThat((i + 1) % 15).isZero();
            }
        }
    }
}