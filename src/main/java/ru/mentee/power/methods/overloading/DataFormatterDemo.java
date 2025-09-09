package ru.mentee.power.methods.overloading;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DataFormatterDemo {
    public static void main(String[] args) {
        int number = 1234567;
        System.out.println("Форматирование целого числа: " + DataFormatter.format(number));
        System.out.println("Форматирование с префиксом и суффиксом: " +
                DataFormatter.format(number, "$", "USD"));

        double doubleNumber = 1234.567;
        System.out.println("Форматирование числа с плавающей точкой: " +
                DataFormatter.format(doubleNumber));
        System.out.println(String.format("Форматирование с 4 десятичными знаками: " +
                DataFormatter.format(doubleNumber, 4)));

        Date now = new Date();
        System.out.println("Форматирование текущей даты: " + DataFormatter.format(now));
        System.out.println("Форматирование с шаблоном: " +
                DataFormatter.format(now, "EEEE, dd MMMM yyyy"));

        List<String> fruits = Arrays.asList("apple", "banana", "orange");
        System.out.println("Форматирование списка: " + DataFormatter.format(fruits));
        System.out.println("Форматирование списка с разделителем: " +
                DataFormatter.format(fruits, " -> "));
    }
}