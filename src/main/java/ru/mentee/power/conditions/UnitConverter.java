package ru.mentee.power.conditions;

import java.util.*;

public class UnitConverter {
    private static final double ERROR_CODE = -1.0;
    public static final String METER = "Метр";
    public static final String CENTIMETER = "Сантиметр";
    public static final String INCH = "Дюйм";
    public static final String FOOT = "Фут";
    public static final String KILOGRAM = "Килограмм";
    public static final String GRAM = "Грамм";
    public static final String POUND = "Фунт";
    public static final String OUNCE = "Унция";
    public static final String CELSIUS = "Цельсий";
    public static final String FAHRENHEIT = "Фаренгейт";
    public static final String KELVIN = "Кельвин";
    private static final List<String> LENGTH_UNITS = Arrays.asList(METER, CENTIMETER, INCH, FOOT);
    private static final List<String> WEIGHT_UNITS = Arrays.asList(KILOGRAM, GRAM, POUND, OUNCE);
    private static final List<String> TEMP_UNITS = Arrays.asList(CELSIUS, FAHRENHEIT, KELVIN);


    public double convert(double value, String fromUnit, String toUnit) {
        fromUnit = normalizeUnit(fromUnit);
        toUnit = normalizeUnit(toUnit);
        if (!isUnitSupported(fromUnit) || !isUnitSupported(toUnit)) {
            return ERROR_CODE;
        }

        if (!areSameCategory(fromUnit, toUnit)) {
            return ERROR_CODE;
        }

        return switch (getCategory(fromUnit)) {
            case "Длина" -> convertLength(value, fromUnit, toUnit);
            case "Вес" -> convertWeight(value, fromUnit, toUnit);
            case "Температура" -> convertTemperature(value, fromUnit, toUnit);
            default -> ERROR_CODE;
        };
    }

    private String normalizeUnit(String unit) {
        if (unit == null) return null;
        return unit.substring(0, 1).toUpperCase() + unit.substring(1).toLowerCase();
    }

    private boolean isUnitSupported(String unit) {
        return unit != null &&
                (LENGTH_UNITS.contains(unit) ||
                        WEIGHT_UNITS.contains(unit) ||
                        TEMP_UNITS.contains(unit));
    }

    private boolean areSameCategory(String unit1, String unit2) {
        String category1 = getCategory(unit1);
        return category1 != null && category1.equals(getCategory(unit2));
    }

    private String getCategory(String unit) {
        if (unit == null) return null;
        if (LENGTH_UNITS.contains(unit)) return "Длина";
        if (WEIGHT_UNITS.contains(unit)) return "Вес";
        if (TEMP_UNITS.contains(unit)) return "Температура";
        return null;
    }

    private double convertLength(double value, String fromUnit, String toUnit) {
        double meters = switch (fromUnit) {
            case METER -> value;
            case CENTIMETER -> value / 100;
            case INCH -> value / 39.37;
            case FOOT -> value / 3.28;
            default -> ERROR_CODE;
        };

        if (meters == ERROR_CODE) return ERROR_CODE;
        return switch (toUnit) {
            case METER -> meters;
            case CENTIMETER -> meters * 100;
            case INCH -> meters * 39.37;
            case FOOT -> meters * 3.28;
            default -> ERROR_CODE;
        };
    }

    private double convertWeight(double value, String fromUnit, String toUnit) {
        double kilograms = switch (fromUnit) {
            case KILOGRAM -> value;
            case GRAM -> value / 1000;
            case POUND -> value / 2.20462;
            case OUNCE -> value / 35.274;
            default -> ERROR_CODE;
        };
        if (kilograms == ERROR_CODE) return ERROR_CODE;

        return switch (toUnit) {
            case KILOGRAM -> kilograms;
            case CENTIMETER -> kilograms * 1000;
            case POUND -> kilograms * 2.20462;
            case FOOT -> kilograms * 35.274;
            default -> ERROR_CODE;
        };
    }

    private double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equals(toUnit)) return value;

        double celsius = switch (fromUnit) {
            case CELSIUS -> value;
            case FAHRENHEIT -> (value - 32) * 5.0 / 9.0;
            case KELVIN -> value - 273.15;
            default -> ERROR_CODE;
        };

        if (celsius == ERROR_CODE) return ERROR_CODE;

        return switch (toUnit) {
            case CELSIUS -> celsius;
            case FAHRENHEIT -> (celsius * 9.0 / 5.0) + 32;
            case KELVIN -> celsius + 273.15;
            default -> ERROR_CODE;
        };
    }

    public static void main(String[] args) {
        UnitConverter converter = new UnitConverter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение:");
        double val = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введите исходную единицу:");
        String from = scanner.nextLine();
        System.out.println("Введите целевую единицу:");
        String to = scanner.nextLine();
        double result = converter.convert(val, from, to);
        if (result == ERROR_CODE) {
            System.out.println("Ошибка конвертации!");
        } else {
            System.out.println("Результат: " + result);
        }
        scanner.close();
    }
}