package ru.mentee.power.conditions;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarEcoRating {
    private static final int ERROR_CODE = -1;
    private static final String ELECTRIC = "Электро";
    private static final String HYBRID = "Гибрид";
    private static final String DIESEL = "Дизель";
    private static final String PETROL = "Бензин";
    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 100;
    private static final int BASE_RATING_ELECTRIC = 90;
    private static final int BASE_RATING_HYBRID = 70;
    private static final int BASE_RATING_DIESEL = 40;
    private static final int BASE_RATING_PETROL = 30;
    private static final List<String> VALID_FUEL_TYPES = Arrays.asList(ELECTRIC, HYBRID, DIESEL, PETROL);
    private static final int euroStandardYearThreshold = 2021;

    public int calculateEcoRating(String fuelType, double engineVolume, double fuelConsumption, int yearOfManufacture, boolean isEuroCompliant) {
        if (!validateInput(fuelType, engineVolume, fuelConsumption, yearOfManufacture)) {
            return ERROR_CODE;
        }

        int baseRating = getBaseFuelTypeRating(fuelType);
        if (baseRating == ERROR_CODE) {
            return ERROR_CODE;
        }
        int finalRating = applyRatingModifiers(
                baseRating, fuelType, engineVolume,
                fuelConsumption, yearOfManufacture, isEuroCompliant);
        return clampRating(finalRating);
    }

    private boolean validateInput(String fuelType, double engineVolume,
                                  double fuelConsumption, int yearOffManufacture) {
        if (fuelType == null || !VALID_FUEL_TYPES.contains(fuelType)) {
            return false;
        }
        if (engineVolume < 0 || fuelConsumption < 0) {
            return false;
        }
        if (fuelType.equals(ELECTRIC) && engineVolume != 0) {
            return false;
        }

        int currentYear = Year.now().getValue();
        return yearOffManufacture <= currentYear;

    }

    private int getBaseFuelTypeRating(String fuelType) {
        return switch (fuelType) {
            case ELECTRIC -> BASE_RATING_ELECTRIC;
            case HYBRID -> BASE_RATING_HYBRID;
            case DIESEL -> BASE_RATING_DIESEL;
            case PETROL -> BASE_RATING_PETROL;
            default -> ERROR_CODE;
        };
    }

    private static int applyRatingModifiers(int baseRating, String fuelType, double engineVolume,
                                            double fuelConsumption, int yearOfManufacture,
                                            boolean isEuroCompliant) {
        double rating = baseRating;
        if (!fuelType.equals(ELECTRIC)) {
            rating -= engineVolume * 5;
        }
        if (fuelType.equals(ELECTRIC)) {
            rating -= fuelConsumption * 0.5;
        } else {
            rating -= fuelConsumption * 2;
        }
        if (isEuroCompliant && !fuelType.equals(ELECTRIC)) {
            rating += 10;
        }
        if (fuelType.equals(HYBRID) && fuelConsumption < 5) {
            rating += 15;
        }
        if (yearOfManufacture < euroStandardYearThreshold) {
            rating -= (euroStandardYearThreshold - yearOfManufacture);
        }
        return (int) Math.round(rating);
    }

    private int clampRating(int rating) {
        return Math.clamp(rating, MIN_RATING, MAX_RATING);
    }

    public static void main(String[] args) {
        CarEcoRating ecoRating = new CarEcoRating();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Тип топлива (Бензин, Дизель, Гибрид, Электро)");
        String type = scanner.nextLine();
        System.out.println("Объем двигателя (л):");
        double volume = scanner.nextDouble();
        System.out.println("Расход топлива(л/100км или кВтч/100км):");
        double consumption = scanner.nextDouble();
        System.out.println("Год выпуска:");
        int year = scanner.nextInt();
        System.out.println("Соответствует стандарту Евро-6 (true/false)");
        boolean isEuro = scanner.nextBoolean();
        int rating = ecoRating.calculateEcoRating(type, volume, consumption, year, isEuro);
        if (rating == ERROR_CODE) {
            System.out.println("Ошибка: некорректные входные данные");
        } else {
            System.out.println("Эко-рейтинг автомобиля: " + rating);
        }
        scanner.close();
    }
}