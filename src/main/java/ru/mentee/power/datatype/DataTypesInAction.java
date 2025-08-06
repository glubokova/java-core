package ru.mentee.power.datatype;

public class DataTypesInAction {
    public static void main(String[] args) {
        int a = 7;
        int b = 2;
        System.out.println("1.Целочисленное деление: ");
        System.out.println("  " + a + " / " + b + " = " + (a / b) +
                "(дробная часть отбрасывается)\n");

        System.out.println("2. Деление с плавающей точкой:");
        System.out.println("   " + a + " / " + b + ".0 = " + (a / (double) b) +
                "(результат с плавающей точкой) \n");

        System.out.println("3. Явное приведение типов:");
        double d = 3.75;
        System.out.println("  double " + d + " к int: " + (int) d +
                " (дробная часть отбрасывается)");

        int code = 65;
        System.out.println("  int " + code + " К char: '" + (char) code +
                " ( символ с кодом " + code + ")");

        long bigNum = 1000000000000L;

        System.out.println("  long " + bigNum + "k int: " + (int) bigNum +
                "(переполнение)\n");

        System.out.println("4. Автоматическое повышение типа: ");
        byte x = 10;
        byte y = 20;
        System.out.println("  byte + byte = int: " + x + " + " + y + " = " + (x + y) +
                " (тип результата  int)");

        int i = 5;
        double f = 2.5;
        System.out.println("  int * double = double: " + i + " * " + f + " = " + (i * f) +
                " (тип результата double)\n");

        System.out.println("5. Операция с boolean: ");
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println("   " + bool1 + " && " + bool2 + " = " + (bool1 && bool2));
        System.out.println("   " + bool1 + " || " + bool2 + " = " + (bool1 || bool2));
        System.out.println("   !" + bool1 + " = " + (!bool1) + "\n");

        System.out.println("6. Работа с символами:");
        char ch = 'A';
        System.out.println("   Символ '" + ch + "'имеет код: " + (int) ch);
        System.out.println("   Символ с кодом 66: '" + (char) 66 + "'");
        System.out.println("   '" + ch + "' +1 = '" + (char) (ch + 1) +
                "' (символ сдвигается на 1 позицию в таблице Unicode)");
    }
}