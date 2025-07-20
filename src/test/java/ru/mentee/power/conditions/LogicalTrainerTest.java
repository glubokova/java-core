package ru.mentee.power.conditions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;


class LogicalTrainerTest {

    @Test
    void testEvaluteLogic_AllTrue() {
        Map<Integer, Boolean> results = LogicalTrainer.evaluateLogic(true, true, true);
        assertThat(results.get(1)).as("1:Prog && Math").isTrue();
        assertThat(results.get(2)).as("2: Prog || Reading").isTrue();
        assertThat(results.get(3)).as("3: Math && !Reading").isFalse();
        assertThat(results.get(4)).as("4: !Prog && !Math").isFalse();
        assertThat(results.get(5)).as("5: Prog || Math | |Reading").isTrue();
        assertThat(results.get(6)).as("6: Dislikes==2").isFalse();
    }

    @Test
    void testEvaluateLogic_ProgAndMathOnly() {
        Map<Integer, Boolean> results = LogicalTrainer.evaluateLogic(true, true, false);
        assertThat(results.get(1)).as("1: Prog && Math").isTrue();
        assertThat(results.get(2)).as("2: Prog || Reading").isTrue();
        assertThat(results.get(3)).as("3: Math && !Reading").isTrue();
        assertThat(results.get(4)).as("4: !Prog && !Math").isFalse();
        assertThat(results.get(5)).as("5: Prog || Math || Reading").isTrue();
        assertThat(results.get(6)).as("6: Dislikes == 2").isFalse();
    }

    @Test
    void testEvaluteLogic_ReadingOnly() {
        Map<Integer, Boolean> results = LogicalTrainer.evaluateLogic(false, false, true);
        assertThat(results.get(1)).as("1:Prog && Math").isFalse();
        assertThat(results.get(2)).as("2: Prog || Reading").isTrue();
        assertThat(results.get(3)).as("3: Math && !Reading").isFalse();
        assertThat(results.get(4)).as("4: !Prog && !Math").isTrue();
        assertThat(results.get(5)).as("5: Prog || Math | |Reading").isTrue();
        assertThat(results.get(6)).as("6: Dislikes==2").isTrue();
    }

    @Test
    void testEvaluteLogic_AllFalse() {
        Map<Integer, Boolean> results = LogicalTrainer.evaluateLogic(false, false, false);
        assertThat(results.get(1)).as("1:Prog && Math").isFalse();
        assertThat(results.get(2)).as("2: Prog || Reading").isFalse();
        assertThat(results.get(3)).as("3: Math && !Reading").isFalse();
        assertThat(results.get(4)).as("4: !Prog && !Math").isTrue();
        assertThat(results.get(5)).as("5: Prog || Math | |Reading").isFalse();
        assertThat(results.get(6)).as("6: Dislikes==3").isFalse();
    }
}