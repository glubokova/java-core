package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class WeekdayDeterminerTest {

    @Test
    void testGetDescription_Monday() {
        assertThat(WeekdayDeterminer.getDayDescription(1))
                .isEqualTo("Понедельник - рабочий день\nТяжелый день");
    }

    @Test
    void testGetDayDescription_Wednesdey() {
        assertThat(WeekdayDeterminer.getDayDescription(3))
                .isEqualTo("Среда - рабочий день\nСередина недели");
    }

    @Test
    void testGetDayDescription_Friday() {
        assertThat(WeekdayDeterminer.getDayDescription(5))
                .isEqualTo("Пятница - рабочий день\nСкоро выходные!");
    }

    @Test
    void testGetDayDescription_Saterday() {
        assertThat(WeekdayDeterminer.getDayDescription(6))
                .isEqualTo("Суббота - выходной");
    }

    @Test
    void testGetDayDescription_Sunday() {
        assertThat(WeekdayDeterminer.getDayDescription(7))
                .isEqualTo("Воскресенье - выходной");
    }

    @Test
    void testGetDayDescription_InvalidDay() {
        assertThat(WeekdayDeterminer.getDayDescription(0)).isEqualTo("Некорректный день недели");
        assertThat(WeekdayDeterminer.getDayDescription(8)).isEqualTo("Некорректный день недели");
        assertThat(WeekdayDeterminer.getDayDescription(-5)).isEqualTo("Некорректный день недели");
    }
}