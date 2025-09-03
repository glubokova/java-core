package ru.mentee.power.loop;

import static org.assertj.core.api.InstanceOfAssertFactories.array;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayStatisticsTest {

    @Test
    void testFindMinMax() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMin()).isEqualTo(1);
        assertThat(stats.findMax()).isEqualTo(9);
    }

    @Test
    void testCalculateSumAndAverage() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics((testData));
        assertThat(stats.calculateSum()).isEqualTo(51);
        assertThat(stats.calculateAverage()).isEqualTo(5.1);
    }

    @Test
    void testCalculateMedian() {
        int[] testData1 = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        int[] testData2 = {5, 7, 2, 9, 3, 5, 1, 8, 5};

        ArrayStatistics stats1 = new ArrayStatistics(testData1);
        ArrayStatistics stats2 = new ArrayStatistics(testData2);
        assertThat(stats1.calculateMedian()).isEqualTo(5.0);
        assertThat(stats2.calculateMedian()).isEqualTo(5.0);
    }

    @Test
    void testFindMode() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.findMode()).isEqualTo(5);
    }

    @Test
    void testCalculateStandardDeviation() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        double rounded = Math.round(stats.calculateStandardDeviation() * 100) / 100.0;
        assertThat(rounded).isEqualTo(2.43);
    }

    @Test
    void testCountGreaterAndLessThan() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.countGreaterThan(5)).isEqualTo(4);
        assertThat(stats.countLessThan(5)).isEqualTo(3);
    }

    @Test
    void testContains() {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        assertThat(stats.contains(7)).isTrue();
        assertThat(stats.contains(10)).isFalse();
    }

    @Test
    void testEmpty() {
        int[] empty = {};
        ArrayStatistics stats = new ArrayStatistics(empty);
        assertThat(stats.findMin()).isEqualTo(Integer.MAX_VALUE);
        assertThat(stats.findMax()).isEqualTo(Integer.MIN_VALUE);
        assertThat(stats.calculateSum()).isZero();
        assertThat(stats.calculateAverage()).isZero();
        assertThat(stats.calculateMedian()).isZero();
        assertThat(stats.findMode()).isZero();
        assertThat(stats.calculateStandardDeviation()).isZero();
        assertThat(stats.countGreaterThan(0)).isZero();
        assertThat(stats.countLessThan(0)).isZero();
        assertThat(stats.contains(0)).isFalse();
    }

    @Test
    void testSingleElementArray() {
        int[] single = {-42};
        ArrayStatistics stats = new ArrayStatistics(single);
        assertThat(stats.findMin()).isEqualTo(-42);
        assertThat(stats.findMax()).isEqualTo(-42);
        assertThat(stats.calculateSum()).isEqualTo(-42);
        assertThat(stats.calculateAverage()).isEqualTo(-42.0);
        assertThat(stats.calculateMedian()).isEqualTo(-42.0);
        assertThat(stats.findMode()).isEqualTo(-42);
        assertThat(stats.calculateStandardDeviation()).isZero();
        assertThat(stats.countGreaterThan(-50)).isEqualTo(1);
        assertThat(stats.countLessThan(0)).isEqualTo(1);
        assertThat(stats.contains(-42)).isTrue();
    }

    @Test
    void testArrayWithDuplicates() {
        int[] dupes = {3, 3, 3, 7, 7};
        ArrayStatistics stats = new ArrayStatistics(dupes);
        assertThat(stats.findMode()).isEqualTo(3);
        assertThat(stats.calculateMedian()).isEqualTo(3.0);
    }

    @Test
    void testArrayWithNegativeValues() {
        int[] negative = {-5, -3, -1, -7, -2};
        ArrayStatistics stats = new ArrayStatistics(negative);
        assertThat(stats.findMin()).isEqualTo(-7);
        assertThat(stats.findMax()).isEqualTo(-1);
        assertThat(stats.calculateSum()).isEqualTo(-18);
        assertThat(stats.calculateAverage()).isEqualTo(-3.6);
        assertThat(stats.calculateMedian()).isEqualTo(-3.0);
        assertThat(stats.findMode()).isEqualTo(-7);
    }
}