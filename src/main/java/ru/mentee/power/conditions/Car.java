package ru.mentee.power.conditions;

import java.util.Locale;
import java.util.Scanner;

public class Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введи свой возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Есть у вас водительские права? (да/нет");
        String hasLicense = scanner.nextLine().toLowerCase();

        boolean carRent = age >= 18 && hasLicense.equals("да");

        if (carRent) {
            System.out.println("Вы можете арендовать автомобиль!");
        } else {
            System.out.println("Вы не можете арендовать автомобиль:(");
            if (age < 18) {
                System.out.println("Причина: не совершеннолетний, вам нет 18!");
            }
            if (!hasLicense.equals("да")) {
                System.out.println("Причина: У вас нет водительсьского удостовериения");
            }
        }
        scanner.close();
    }
}