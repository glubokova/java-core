package ru.mentee.power.datatype;

public class DataType {
    public static final int B = 127;
    public static final int I = 2147483647;
    public static final int S = 32767;
    public static final long L = 9223372036854775807L;
    public static final float F = 3.14f;
    public static final double D = 3.141592653589793f;
    public static final char C = 'Q';

    public static void main(String[] args) {

        // Целочисленные типы даннst

        System.out.println("=== Примитивные типы данных===");
        System.out.println("= Целочисленные =");
        System.out.println("byte: " + B);
        System.out.println("int:" + I);
        System.out.println("short: " + S);
        System.out.println("long: " + L);

        // Типы данных с плавающей точкой;

        System.out.println("\n\n= С плавающей точкой =");
        System.out.println("double: " + D);
        System.out.println("float " + F + "f");

        // Символьный тип данных, Unicode кодировка

        System.out.println("char: " + C);

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
        int sumInt = I + 14;
        double sumDouble = D + 1.5;
        float sumFloat = F + 1.0f;
        double intDouble = I + D;

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
        double id = I;
        float fl = L;

        // Явное преобразование
        int di = (int) D;
        byte bi = (byte) I;

        //Преобразование строки в число
        String numberStr = "123";
        int fromString = Integer.parseInt(numberStr);
        String toString = Integer.toString(I);

        System.out.println("\n\n=== Преобразование типов ===");
        System.out.println("Неявное преобразование, double -> int: " + di + ", float -> long: " + fl);
        System.out.println("Явное преобразование, int -> double: " + di + ", byte -> int: " + bi);

        System.out.println("String 123 -> int: " + fromString);
        System.out.println("int - > String: " + toString);
    }
}