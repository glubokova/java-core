package ru.mentee.power.datatype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenteeTest {

    @Test
    public void testMenteeCreation() {
        Mentee mentee = new Mentee("Иван", "Иванов", 20, 4.2, 2);

        assertEquals("Иван", mentee.getName());
        assertEquals("Иванов", mentee.getLastName());
        assertEquals(20, mentee.getAge());
        assertEquals(4.2, mentee.getAverageGrade());
        assertEquals(2, mentee.getLevel());
    }

    @Test
    public void testIsExcelelent() {
        Mentee excellentMentee = new Mentee("Мария", "Петрова", 19, 4.8, 1);
        Mentee averageMentee = new Mentee("Петр", "Сидоров", 21, 3.9, 3);
        assertTrue(excellentMentee.isExcellent());
        assertFalse(averageMentee.isExcellent());
    }

    @Test
    public void testAdvabceToNextLevel() {
        Mentee junior = new Mentee("Алексей", "Смирнов", 18, 4.0, 1);
        Mentee senior = new Mentee("Ольга", "Козлова", 22, 4.7, 5);
        assertTrue(junior.advanceToNextLevel());
        assertEquals(2, junior.getLevel());
        assertFalse(senior.advanceToNextLevel());
        assertEquals(5, senior.getLevel());
    }

    @Test
    public void testInvalidLevelvalue() {
        Mentee mentee1 = new Mentee("Дмитрий", "Попов", 19, 4.3,  0);
        Mentee mentee2 = new Mentee("Анна", "Соколова", 20, 4.5, 6);
        assertEquals(1, mentee1.getLevel());
        assertEquals(1,mentee2.getLevel());
    }

    @Test
    public void testCalculatorScholarship() {
        Mentee excellentMentee = new Mentee("Мария","Ивановна", 19, 4.8, 1);
        assertEquals(2000, excellentMentee.calculateScholarship());

        Mentee goodMentee = new Mentee("Алексей Смирнов", "", 18, 4.2, 1 );
        assertEquals(1500, goodMentee.calculateScholarship());

        Mentee averageMentee = new Mentee("Петр", "Сидоров", 21, 3.9, 3);
        assertEquals(1000, averageMentee.calculateScholarship());

        Mentee borderLineMentee1 = new Mentee("Ольга", "Козлова", 22, 4.5, 5);
        assertEquals(2000, borderLineMentee1.calculateScholarship());

        Mentee borderLineMentee2 = new Mentee("Иван", "Иванов", 20, 4.0, 2);
        assertEquals(1500, borderLineMentee2.calculateScholarship());
    }
}