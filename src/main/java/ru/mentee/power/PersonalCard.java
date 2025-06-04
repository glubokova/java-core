package ru.mentee.power;

public class PersonalCard {
    public static void main(String[] args) {
        String lastName = "Glubokova";
        String name = "Aida";
        String city = "Orenburg";
        int age = 23;
        double weight = 83.5;
        double height = 170.0;
        boolean student = true;
        char firstLetter = 'A';

        System.out.println("==== Personal card ====");
        System.out.println("LastName: " + lastName);
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Age: " + age + "years");
        System.out.println("Weight: " + weight + "kg");
        System.out.println("Height; " + height + "cm");
        System.out.println("Student: " + student);
        System.out.println("The first letter of the name: " + firstLetter);
        System.out.println("========================");
    }
}