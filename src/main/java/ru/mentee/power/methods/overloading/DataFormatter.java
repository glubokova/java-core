package ru.mentee.power.methods.overloading;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DataFormatter {
    public static String format(int value) {
        if (value == 0) return "0";
        boolean isNegative = value < 0;
        int absoluteValue = Math.abs(value);

        StringBuilder result = new StringBuilder();
        int counter = 0;

        while (absoluteValue > 0) {
            int digit = absoluteValue % 10;
            absoluteValue /= 10;

            if (counter > 0 && counter % 3 == 0) {
                result.insert(0, " ");
            }
            result.insert(0, digit);
            counter++;
        }
        if (isNegative) {
            result.insert(0, "-");
        }
        return result.toString();
    }

    public static String format(int value, String prefix, String suffix) {
        String number = format(value);
        return prefix + number + " " + suffix;
    }

    public static String format(double value) {
        return format(value, 2);
    }

    public static String format(double value, int decimalPlaces) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator(',');

        String pattern;
        if (decimalPlaces==0) {
            pattern= "#,##0";
        } else {
            pattern = "#,##0.";
            for (int i = 0; i < decimalPlaces; i++) {
                pattern += "0";
            }
        }

        DecimalFormat format = new DecimalFormat(pattern, symbols);
        return format.format(value);
    }

    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern,
                Locale.forLanguageTag("ru-RU"));
        return sdf.format(date);
    }

    public static String format(List<String> items) {
        return String.join(", ", items);
    }

    public static String format(List<String> items, String delimeter) {
        return String.join(delimeter, items);
    }
}