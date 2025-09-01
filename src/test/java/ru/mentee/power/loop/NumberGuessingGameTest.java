package ru.mentee.power.loop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;

class NumberGuessingGameTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testPlayRoundGuessCorrectly() {
        String input = "50\n30\n40\n42\nнет";
        Scanner testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        NumberGuessingGame game = new TestableNumberGuessingGame(42, testScanner);

        game.startGame();
        testScanner.close();

        String output = outputStream.toString();
        assertThat(output).contains("Я загадал число")
                .contains("больше")
                .contains("меньше")
                .contains("Поздравляю! Вы угадали число 42")
                .contains("за 4 попыток");
    }

    @Test
    void testStatisticsUpdated() {
        String input = "30\n40\n42\nд\n60\n50\n40\n45\n42\nнет";
        Scanner testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        NumberGuessingGame game = new TestableNumberGuessingGame(42, testScanner);

        game.startGame();
        testScanner.close();

        String output = outputStream.toString();
        assertThat(output).contains("Минимум попыток: 3")
                .contains("Максимум попыток: 5")
                .contains("Сыграно игр: 2");
        assertThat(output).containsPattern("Среднее количество попыток: 4[.,]0");
    }

    @Test
    void testInvalidInput() {
        String input = "abc\n-5\n200\n42\nнет";
        Scanner testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        NumberGuessingGame game = new TestableNumberGuessingGame(42, testScanner);

        game.startGame();
        testScanner.close();

        String output = outputStream.toString();
        assertThat(output).contains("введите целое число")
                .contains("введите число в диапазоне от 1 до 100")
                .contains("Поздравляю! Вы угадали число 42");
    }

    static class TestableNumberGuessingGame extends NumberGuessingGame {
        private final int fixedNumber;

        TestableNumberGuessingGame(int fixedNumber, Scanner scanner) {
            super(new TestableRandom(fixedNumber), scanner);
            this.fixedNumber = fixedNumber;
        }
    }

    static class TestableRandom extends Random {
        private final int value;

        TestableRandom(int value) {
            this.value = value;
        }

        @Override
        public int nextInt(int bound) {
            return value - 1;
        }
    }
}