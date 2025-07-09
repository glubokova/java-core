package ru.mentee.power.variables;

public class DataType {
    public static void main(String[] args) {
        // Целочисленные типы данных
        byte b = 127;
        int i = 2147483647;
        short s = 32767;
        long l = 9223372036854775807L;

        System.out.println("=== Примитивные типы данных===");
        System.out.println("= Целочисленные =");
        System.out.println("byte: " + b);
        System.out.println("int:" + i);
        System.out.println("short: " + s);
        System.out.println("long: " + l);

        // Типы данных с плавающей точкой
        double d = 3.141592653589793;
        float f = 3.14f;

        System.out.println("\n\n= С плавающей точкой =");
        System.out.println("double: " + d);
        System.out.println("float " + f + "f");

        // Символьный тип данных, Unicode кодировка

        char c = 'Q';
        System.out.println("char: " + c);

        // Логический тип данных использует значение true или false

        boolean myBoolean = true;

        System.out.println("Аида получит оффер через 3 месяца? : " + myBoolean);

        //Создание строк и массивов

        String greeting = "Hello World";
        String fullName = "Даниил Викторович";

        int[] arrayInt = {1, 2, 3, 4, 5, 6};
        String[] arrrayString = {"One", "Two", "Three"};

        System.out.println("\n\n= Строки и массивы=");
        System.out.println("String 1: " + greeting);
        System.out.println("String 2: " + fullName);

        // Математические операции с разными типами данных
        int sumInt = i + 14;
        double sumDouble = d + 1.5;
        float sumFloat = f + 4.5f;
        double intDouble = i + d;

        int divisionInt = 15 / 4;
        double divisionDouble = 15.5 / 4;

        System.out.println("\n\n=== Математические операции ===");
        System.out.println("i + 14" + sumInt);
        System.out.println("d + 1.5 " + sumDouble);
        System.out.println("f + 4.5f: " + sumFloat);
        System.out.println("i + d: " + intDouble);
        System.out.println("15/4: " + divisionInt);
        System.out.println("15.5/4: " + divisionDouble);

        //Преобразование типов
        // Неявное преобразование
        double id = i;
        float fl = l;

        // Явное преобразование
        int di = (int) d;
        byte bi = (byte) i;

        //Преобразование строки в число
        String numberStr = "123";
        int fromString = Integer.parseInt(numberStr);
        String toString = Integer.toString(i);

        System.out.println("\n\n=== Преобразование типов ===");
        System.out.println("Неявное преобразование, double -> int: " + di + ", float -> long: " + fl);
        System.out.println("Явное преобразование, int -> double: " + di + ", byte -> int: " + bi);

        System.out.println("String 123 -> int: " + fromString);
        System.out.println("int - > String: " + toString);
    }
}
