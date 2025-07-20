package ru.mentee.power.datatype;

public class SmartCalculator {
    public static void main(String[] args) {
        System.out.println("Умный калькулятор:");
        int a = 5, b = 3;
        System.out.println("Сложение: " + a + " + " + b + " = " + (a + b) + "(тип: int)");
        double c = 5.5, d = 2.2;
        System.out.println("Вычитание: " + c + " - " + d + " = " + (c - d) + " (тип: double)");
        int e = 4;
        double f = 2.5;
        System.out.println("Умножение: " + e + " * " + f + " = " + (e + f) + " (тип: double)");
        int g = 10, h = 3;
        System.out.println("Деление: " + g + " / " + h + " = " + (g / h) + " (тип: int)");
        System.out.println("Деление целочисленное: " + g + " / " + h + " = " + (g / h) + " (тип: int)");
        System.out.println("Остаток от деления: " + g + " % " + h + " = " + (g % h) + "(тип: int)");
        int base = 2, exponent = 10;
        System.out.println("Возведение в степень: " + base + " ^ " + exponent + " = " +
                Math.pow(base, exponent) + "(тип: double)");
        System.out.println("\nОбработка особых случаев: ");
        try {
            double zeroD = 0.0;
            System.out.println("Попытка деления на ноль(для double): " + (c / zeroD));
            int zeroI = 0;
            System.out.println("Попытка деления на ноль (для int): " + (a / zeroI));
        } catch (ArithmeticException ex) {
            System.out.println("Попытка деления на ноль (для int) : Exeption in thread \"main\" " +
                    ex.getClass().getName());
        }

    }
}