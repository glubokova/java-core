package ru.mentee.power.variables;

public class TypeCalculator {
    public static void main(String[] args) {
        byte byteNum = 5;
        short shortNum = 10;
        int intNum = 1000;
        long longNum = 10000L;
        float floatNum = 3.14f;
        double doubleNum = 5.5;

        int result1 = byteNum + shortNum;
        System.out.println("byte (" + byteNum + ") + short (" + shortNum + ") = " +
                result1 + " (int)");

        int result2 = intNum * byteNum;
        System.out.println("int (" + intNum + ") * byte (" + byteNum + ") = " +
                result2 + " (int)");

        double result3 = doubleNum + intNum;
        System.out.println("double (" + doubleNum + ") + int (" + intNum + ") = " +
                result3 + " (double)");

        int result4 = intNum / 2;
        System.out.println("int (" + intNum + ") / int (2) = " +
                result4 + " (int)");

        double result5 = doubleNum / 2;
        System.out.println("double (" + doubleNum + ") / int (2) = " +
                result5 + " (double)");

        float result6 = longNum + floatNum;
        System.out.println("long (" + longNum + ") + float (" + floatNum + ") = " +
                result6 + " (float)");

        double result7 = floatNum * doubleNum;
        System.out.println("float (" + floatNum + ") * double (" + doubleNum+ ") = " +
                result7 + " (double)");
    }
}