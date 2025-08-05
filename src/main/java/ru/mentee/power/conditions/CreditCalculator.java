package ru.mentee.power.conditions;

import java.util.Scanner;

public class CreditCalculator {
    private static final double MORTGAGE_RATE = 9.0;
    private static final double CONSUMER_RATE = 15.0;
    private static final double CAR_LOAN_RATE = 12.0;

    private static final int MIN_CREDIT_SCORE = 300;
    private static final int MAX_CREDIT_SCORE = 850;
    private static final int EXCELLENT_SCORE = 700;
    private static final int GOOD_SCORE = 650;
    private static final int FAIR_SCORE = 500;

    private static final double MIN_LOAN_AMOUNT = 10000;
    private static final double MAX_LOAN_AMOUNT = 10000000;
    private static final double MIN_LOAN_TERM = 1;
    private static final double MAX_LOAN_TERM = 360;

    public double calculateMonthlyPayment(double loanAmount, int loanTermMonths, String creditType, int creditScore) {
        if (loanAmount < MIN_LOAN_AMOUNT || loanAmount > MAX_LOAN_AMOUNT) {
            return -1;
        }
        if (loanTermMonths < MIN_LOAN_TERM || loanTermMonths > MAX_LOAN_TERM) {
            return -1;
        }
        if (creditScore < MIN_CREDIT_SCORE || creditScore > MAX_CREDIT_SCORE) {
            return -1;
        }
        double baseRate;
        switch (creditType) {
            case "Ипотека":
                baseRate = MORTGAGE_RATE;
                break;
            case "Потребительский":
                baseRate = CONSUMER_RATE;
                break;
            case "Автокредит":
                baseRate = CAR_LOAN_RATE;
                break;
            default:
                return -1;
        }

        double finalRate = adjustRateByCreditScore(baseRate, creditScore);
        double monthlyRate = finalRate / 12 / 100;
        double monthlyPayment = loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, loanTermMonths))
                / (Math.pow(1 + monthlyRate, loanTermMonths) - 1);

        return monthlyPayment;
    }

    private double adjustRateByCreditScore(double baseRate, int creditScore) {
        if (creditScore >= EXCELLENT_SCORE) {
            return baseRate - 2;
        } else if (creditScore >= GOOD_SCORE) {
            return baseRate - 1;
        } else if (creditScore >= FAIR_SCORE) {
            return baseRate + 3;
        }
        return baseRate;
    }

    public static void main(String[] args) {
        CreditCalculator calculator = new CreditCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Калькулятор кредита");
        System.out.println("-------------------");

        try {
            System.out.println("Введите сумму кредита (от 10.000 до 10.000.000 руб.): ");
            double amount = scanner.nextDouble();
            System.out.println("Введите срок кредита в месяцах (от 1 до 360): ");
            int term = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите тип кредита (Ипотека/Потребительский/Автокредит): ");
            String type = scanner.nextLine();
            System.out.println("Введите кредитный рейтинг(300-850): ");
            int score = scanner.nextInt();
            double payment = calculator.calculateMonthlyPayment(amount, term, type, score);

            if (payment == -1) {
                System.out.println("Ошибка: Некорректные данные");
            } else {
                System.out.printf("Ежемесячный платеж: %.2f руб.%n", payment);
            }
        } catch (Exception e) {
            System.out.println("Ошибка: Введены некорректные данные");
        } finally {
            scanner.close();
        }
    }
}