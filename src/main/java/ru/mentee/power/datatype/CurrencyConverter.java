package ru.mentee.power.datatype;

public class CurrencyConverter {
    public static void main(String[] args) {
        final double USD_TO_RUB = 90.50;
        final double EUR_TO_RUB = 98.50;
        final double CNY_TO_RUB = 12.50;

        System.out.println("Курс валют: ");
        System.out.printf("1 USD = %.2f RUB\n", USD_TO_RUB);
        System.out.printf("1 Eur = %.2f RUB\n", EUR_TO_RUB);
        System.out.printf("1 CNY = %.2f RUB\n", CNY_TO_RUB);

        double usdAmount = 100;
        double rubAmount = 100;
        double eurAmount = 50;
        double rubAmount2 = 1000;
        double cnyAmount = 250;

        System.out.println("Kонвертация: ");
        System.out.printf("%.0f USD = %.2f RUB\n", usdAmount, usdAmount * USD_TO_RUB);
        System.out.printf("%.0f RUB = %.2f Usd\n", rubAmount, rubAmount / USD_TO_RUB);
        System.out.printf("%.0f EUR = %.2f RUB\n", eurAmount, eurAmount * EUR_TO_RUB);
        System.out.printf("%.0f RUB = %.2f EUR\n", rubAmount2, rubAmount2 / EUR_TO_RUB);
        System.out.printf("%.0f CNY = %.2f RUB\n\n", cnyAmount, cnyAmount * CNY_TO_RUB);

        System.out.println(" Демонстрация проблем точности с double:");
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
        System.out.println("(" + a + " + " + b + " ) == 0.3? " + (sum == 0.3));
    }
}