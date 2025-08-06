package ru.mentee.power.variables;

public class StringOperations {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        char c = 'A';
        int num = 23;
        String number = "100";
        String language = "Java";

        String concatenated = a + b;
        String charToString = String.valueOf(c);
        String numToString = String.valueOf(num);
        int stringToNum = Integer.parseInt(number);
        char extractingCharFromString = language.charAt(2);

        System.out.println("Конкатенация: \"" + a + "\" + \"" + b + "\" = \"" + concatenated + "\"");
        System.out.println("Символ в строку: '" + c + "' -> \"" + charToString + "\"");
        System.out.println("Число в строку: " + number + " -> \"" + numToString + "\"");
        System.out.println("Строка в число: \"" + stringToNum + "\" -> " + extractingCharFromString);
        System.out.println("Символ из строки \"" + language + "\": индекс 1 -> '" + extractingCharFromString + "'");
    }
}