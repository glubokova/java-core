package ru.mentee.power.datatype;

public class MenteeDemo {
    public static void main(String[] args) {
        Mentee mentee1 = new Mentee("Иван", "Иванов", 20, 4.8, 1);
        Mentee mentee2 = new Mentee("Петр", "Петров", 21, 3.9, 3);
        Mentee mentee3 = new Mentee("Анна", "Сидорова", 19, 5.0, 2);
        Mentee mentee4 = new Mentee("Мария", "Кузнецова", 22, 4.0, 4);
        Mentee mentee5 = new Mentee("Алексей", "Смирнов", 20, 4.5, 2);

        System.out.println("Информация о менти:");
        mentee1.displayInfo();
        System.out.println();
        mentee2.displayInfo();
        System.out.println();
        mentee3.displayInfo();
        System.out.println();
        mentee4.displayInfo();
        System.out.println();
        mentee5.displayInfo();

        System.out.println("\nОтличники:");
        printExcellentMentees(mentee1, mentee2, mentee3, mentee4, mentee5);

        System.out.println("\nПовышение уровня:");
        promoteMentees(mentee1, mentee2, mentee3, mentee4, mentee5);
    }

    private static void printExcellentMentees(Mentee... mentees) {
        for (Mentee mentee : mentees) {
            if (mentee.isExcellent()) {
                System.out.println(mentee.getName() + " " + mentee.getLastName());
            }
        }
    }

    private static void promoteMentees(Mentee... mentees) {
        for (Mentee mentee : mentees) {
            System.out.print(mentee.getName() + " " + mentee.getLastName() +
                    ": уровень " + mentee.getLevel() + " -> ");
            boolean promoted = mentee.advanceToNextLevel();
            if (promoted) {
                System.out.println(mentee.getLevel());
            } else {
                System.out.println("не может быть повышен (максимальный уровень)");
            }
        }
    }
}