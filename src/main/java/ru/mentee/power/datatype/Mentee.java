package ru.mentee.power.datatype;

public class Mentee {
    private String name;
    private String lastName;
    private int age;
    private double averageGrade;
    private int level;

    public Mentee(String name, String lastName, int age,
                  double averageGrade, int level) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.averageGrade = averageGrade;
        this.level = (level >= 1 && level <= 5) ? level : 1;
    }

    public void displayInfo() {
        System.out.println("Менти:" + name + " " + lastName);
        System.out.println("Возраст:" + age);
        System.out.println("Средний балл: " + averageGrade);
        System.out.println("Уровень: " + level);
    }

    public boolean isExcellent() {
        return averageGrade >= 4.5;
    }

    public boolean advanceToNextLevel() {
        if (level < 5) {
            level++;
            return true;
        }
        return false;
    }

    public int calculateScholarship() {
        if (averageGrade >= 4.5) {
            return 2000;
        } else if (averageGrade >= 4.0) {
            return 1500;
        } else {
            return 1000;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}