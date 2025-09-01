package ru.mentee.power.loop;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private final Random random;
    private final Scanner scanner;
    private int gamesPlayed = 0;
    private int minAttempts = Integer.MAX_VALUE;
    private int maxAttempts = 0;
    private int totalAttempts = 0;

    public NumberGuessingGame() {
        this.random = createRandom();
        this.scanner = new Scanner(System.in);
    }

    protected NumberGuessingGame(Random random, Scanner scanner) {
        this.random = random;
        this.scanner = scanner;
    }

    protected Random createRandom() {
        return new Random();
    }

    public void startGame() {
        System.out.println("Добро пожаловать в игру \"Угадай число!\"");
        boolean playAgain;
        do {
            int attempts = playRound();
            updateStatistics(attempts);
            showStatistics();
            playAgain = askPlayAgain();
        } while (playAgain);
        System.out.println("Спасибо за игру!");
    }

    public int playRound() {
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        do {
            System.out.println("Введите ваше предположение (или 'q' для выхода):");
            if (!scanner.hasNext()) {
                break;
            }

            String input = scanner.next();

            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
                System.out.println("Игра прервана. Загаданное число было: " + secretNumber);
                return attempts;
            }

            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число!");
                continue;
            }

            if (guess < 1 || guess > 100) {
                System.out.println("Пожалуйста, введите число в диапазоне от 1 до 100!");
                continue;
            }

            attempts++;
            if (guess == secretNumber) {
                System.out.println("Поздравляю! Вы угадали число " + secretNumber + " за " + attempts + " попыток.");
                guessed = true;
            } else if (guess < secretNumber) {
                System.out.println("Загаданное число больше!");
            } else {
                System.out.println("Загаданное число меньше!");
            }
        } while (!guessed);

        return attempts;
    }

    private void updateStatistics(int attempts) {
        gamesPlayed++;
        totalAttempts += attempts;
        minAttempts = Math.min(minAttempts, attempts);
        maxAttempts = Math.max(maxAttempts, attempts);
    }

    public void showStatistics() {
        if (gamesPlayed == 0) {
            System.out.println("Пока нет сыгранных игр.");
            return;
        }
        double avg = (double) totalAttempts / gamesPlayed;
        System.out.println("===Статистика===");
        System.out.println("Сыграно игр: " + gamesPlayed);
        System.out.println("Минимум попыток: " + minAttempts);
        System.out.println("Максимум попыток: " + maxAttempts);
        System.out.printf("Среднее количество попыток: %.1f%n", avg);
    }

    private boolean askPlayAgain() {
        System.out.print("Хотите сыграть еще раз? (да/нет): ");

        if (!scanner.hasNext()) {
            return false;
        }

        String answer = scanner.next().trim().toLowerCase();
        return answer.startsWith("д") || answer.startsWith("y");
    }

    public void close() {
        scanner.close();
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        try {
            game.startGame();
        } finally {
            game.close();
        }
    }
}