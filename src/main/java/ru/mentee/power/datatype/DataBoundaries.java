package ru.mentee.power.datatype;

public class DataBoundaries {
    public static void main(String[] args) {
        byte maxByte = Byte.MAX_VALUE;
        int maxInt = Integer.MAX_VALUE;

        System.out.println("byte: от " + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.MIN_VALUE + " до " + Short.MAX_VALUE);
        System.out.println("int: " + Integer.MIN_VALUE + " до " + Integer.MAX_VALUE);
        System.out.println("long: " + Long.MIN_VALUE + " до " + Long.MAX_VALUE);
        System.out.println("float: " + Float.MIN_VALUE + " до " + Float.MAX_VALUE);
        System.out.println("double: " + Double.MIN_VALUE + " до " + Double.MAX_VALUE);

        System.out.println("= Демонстрация переполнения для byte: ");
        System.out.println("Максимальное значение byte: " + maxByte);
        System.out.println("После прибавления 1: " + (byte) (maxByte + 1));

        System.out.println("= Демонстрация переполнения для int: ");
        System.out.println(" Максимальное значение int:  " + maxInt);
        System.out.println(" После прибавления 1: " + (maxInt + 1));
    }
}