package ru.mentee.power.datatype;

public class TypePuzzle {
    public static void main(String[] args) {
        System.out.println("Головоломка 1: Сравнение чисел с плавающей точкой");
        System.out.println("0.1 + 0.2 == 0.3? " + (0.1 + 0.2 == 0.3));
        System.out.println("Потому что: 0.1 + 0.2 = " + 0.1 + 0.2);
        System.out.println("Решение: использовать epsilon для сравнения");
        System.out.println("Math.abs((0.1 + 0.2 =  < 0.0001? " +
                (Math.abs((0.1 + 0.2) - 0.3) < 0.0001) + "\n");
        System.out.println("Головоломка 2: Переполнение");
        System.out.println("Integer.MAX_VALUE + 1 = " + (Integer.MAX_VALUE + 1));
        System.out.println("Объяснение: происходит переполнение, счетчик \" перескакивает\" на минимальное значение");
        System.out.println("Правильный подход: проверять на переполнение или использовать Long");
        System.out.println("Math.addExact(Integer.MAX_VALUE, 1): ");
        try {
            System.out.println(Math.addExact(Integer.MAX_VALUE, 1));
        } catch (ArithmeticException e) {
            System.out.println("Выброшено исключение: " + e + "\n");
        }
        System.out.println("Головоломка 3: Странное поведение char");
        System.out.println("'a' + 'b' = " + ('a' + 'b'));
        System.out.println("Объяснение: символы конвертируются в их коды (97 + 98) и складываются как числа");
        System.out.println("Для конкатенации символов: \"\" + 'a' + 'b' = " + ("" + 'a' + 'b') + "\n");
        System.out.println("Головоломка 4: Автоупаковка и null");
        Integer i1 = null;
        try {
            System.out.println(" Integer null + 1: ");
            System.out.println(i1 + 1);
        } catch (NullPointerException e) {
            System.out.println("Выброшено NullPointerExeption\n");
        }

        System.out.println("Головоломка 5: Деление целых чисел");
        System.out.println("1/2 = " + (1 / 2));
        System.out.println("Объяснение: при делении чисел дробная часть отбрасывается");
        System.out.println("Решение: использовать хотя бы один double: 1/2.0 = " + (1 / 2.0) + "/n");

        System.out.println("Головоломка 6: Тернарный оператор и типы");
        Object o = true ? Integer.valueOf(1) : Double.valueOf(2.0);
        System.out.println("true ? 1 : 2.0 = " + o + " тип: " + o.getClass().getSimpleName() + ")");
        System.out.println("ОБъяснение: тернарный оператор приводит обо варианта к общему типу (double");

    }
}