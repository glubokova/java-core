package ru.mentee.power.conditions;

import java.util.Locale;
import java.util.Scanner;

public class TrafficLight {
    public static String getRecommendation(String signal) {
        switch(signal.toLowerCase()) {
            case "красный":
                return "Стойте!";
            case "желтый":
                return "Готовьтесь двигаться";
            case "зеленый":
                return "Двигайтесь осторожно";
            default:
                return "Некорректный сигнал!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Какой сейчас сигнал светофора(Красный, Желтый, Зеленый)?");
        System.out.println("Введите название сигнала: ");

        String signal = scanner.nextLine();
        String recommendation = getRecommendation(signal);
        System.out.println(recommendation);
        scanner.close();
    }
}