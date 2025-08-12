package ru.mentee.power.conditions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static final String ROCK = "камень";
    public static final String PAPER = "бумага";
    public static final String SCISSORS = "ножницы";
    public static final String PLAYER_WINS = "Победа игрока";
    public static final String COMPUTER_WINS = "Победа компьютера";
    public static final String DRAW = "Ничья";
    public static final String ERROR = "Ошибка";
    private static final List<String> VALID_MOVES = Arrays.asList(ROCK, PAPER, SCISSORS);
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public String determineWinner(String playerChoice, String computerChoice) {
        String player = playerChoice.toLowerCase();
        String computer = computerChoice.toLowerCase();
        if (!VALID_MOVES.contains(playerChoice) || !VALID_MOVES.contains(computerChoice)) {
            return ERROR;
        }
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return DRAW;
        }

        return switch (playerChoice.toLowerCase()) {
            case ROCK -> computerChoice.equalsIgnoreCase(SCISSORS) ? PLAYER_WINS : COMPUTER_WINS;
            case PAPER -> computerChoice.equalsIgnoreCase(ROCK) ? PLAYER_WINS : COMPUTER_WINS;
            case SCISSORS -> computerChoice.equalsIgnoreCase(PAPER) ? PLAYER_WINS : COMPUTER_WINS;
            default -> ERROR;
        };
    }

    private boolean validateMove(String move) {
        return VALID_MOVES.contains(move.toLowerCase());
    }

    public String generateComputerMove() {
        return VALID_MOVES.get(random.nextInt(VALID_MOVES.size()));
    }

    public String playGame(String playerChoice) {
        String computerChoice = generateComputerMove();
        String result = determineWinner(playerChoice, computerChoice);
        return "Компьютер выбрал: " + computerChoice + ". Результат: " + result;
    }

    public String playOneGame() {
        System.out.println("Сделайте свой выбор (камень/ножницы/бумага): ");
        String playerChoice = scanner.nextLine();

        if (!validateMove(playerChoice)) {
            System.out.println("Ошибка! Выберите камень, ножницы или бумагу.");
            return playerChoice;
        }
        playerChoice = playerChoice.toLowerCase();
        System.out.println(playGame(playerChoice));
        return playerChoice;
    }


    public void startGameLoop() {
        System.out.println("Добро пожаловать в игру Камень-Ножницы-Бумага!");
        System.out.println("Правила: камень > ножницы > бумага > камень");

        while (true) {
            playOneGame();
            System.out.println("Хотите сыграть еще? (да/нет): ");
            String answer = scanner.nextLine().toLowerCase();

            if (!answer.equals("да")) {
                System.out.println("Спасибо за игру! До свидания!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.startGameLoop();
    }
}