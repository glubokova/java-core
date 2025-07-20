package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrafficLightTest {

    @Test
    void testGetRecommendation_RedSignal() {
        assertThat(TrafficLight.getRecommendation("Красный")).isEqualTo("Стойте!");
        assertThat(TrafficLight.getRecommendation("красный")).isEqualTo("Стойте!");
    }

    @Test
    void testGetRecommendation_YellowSignal() {
        assertThat(TrafficLight.getRecommendation("Жёлтый"));
        assertThat(TrafficLight.getRecommendation("жёлтый"));
    }

    @Test
    void testGetRecommendation_GreenSignal() {
        assertThat(TrafficLight.getRecommendation("Зеленый"));
        assertThat(TrafficLight.getRecommendation("зеленый"));
    }

    @Test
    void testGetRecommendation_InvalidSignal() {
        assertThat(TrafficLight.getRecommendation("Синий")).isEqualTo("Некорректный сигнал!");
        assertThat(TrafficLight.getRecommendation("  ")).isEqualTo("Некорректный сигнал!");
        assertThat(TrafficLight.getRecommendation("null")).isEqualTo("Некорректный сигнал!");
    }

}