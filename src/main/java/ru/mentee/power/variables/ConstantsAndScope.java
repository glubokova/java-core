package ru.mentee.power.variables;

public class ConstantsAndScope {
    public static final double PI = 3.141592653589793;
    private static final int COUNT = 100;
    protected static final String DEFAULT_NAME = "Unknown";

    public static void main(String[] args) {
        int localVar = 42;
        final String LOCAL_CONST = "Hello, World!";

        System.out.println("Доступ к константам класса:");
        System.out.println("PI = " + PI);
        System.out.println("MAX_COUNT = " + COUNT);
        System.out.println("DEFAULT_NAME = " + DEFAULT_NAME);

        System.out.println("\nЛокальные переменные:");
        System.out.println("localVar = " + localVar);
        System.out.println("LOCAL_CONST = " + LOCAL_CONST);

        // Блок кода с собственной областью видимости
        {
            int blockVar = 100;
            final String BLOCK_CONST = "Block constant";

            System.out.println("\nВнутри блока:");
            System.out.println("blockVar = " + blockVar);
            System.out.println("BLOCK_CONST = " + BLOCK_CONST);

            // Доступ к переменным из внешней области видимости
            System.out.println("localVar из блока = " + localVar);
        }

        // Ошибка компиляции - переменная blockVar не видна вне блока
        // System.out.println(blockVar);

        // Ошибка компиляции - BLOCK_CONST не видна вне блока
        // System.out.println(BLOCK_CONST);

        // Вызов метода с его локальными переменными
        someMethod();
    }

    public static void someMethod() {
        // локальные переменные
        int methodVar = 777;
        final String METHOD_CONST = "Method constant";

        System.out.println("\nВнутри someMethod:");
        System.out.println("methodVar = " + methodVar);
        System.out.println("METHOD_CONST = " + METHOD_CONST);

        // Доступ к константам класса
        System.out.println("PI из метода = " + PI);

        // Ошибка компиляции - нет доступа к локальным переменным main
        // System.out.println(localVar);
    }
}