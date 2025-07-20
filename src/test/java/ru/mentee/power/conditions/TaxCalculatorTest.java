package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class TaxCalculatorTest {

    private static final double DELTA = 0.01;

    @Test
    void testCalculateTax_Tier1() {
        assertThat(TaxCalculator.calculateTax(80000.0)).isCloseTo(8000.0, offset(DELTA));
        assertThat(TaxCalculator.calculateTax(100000.0)).isCloseTo(10000.0, offset(DELTA));
    }

    @Test
    void testCalculateTax_Tier2() {
        assertThat(TaxCalculator.calculateTax(200000.0)).isCloseTo(30000.0, offset(DELTA));
        assertThat(TaxCalculator.calculateTax(500000.0)).isCloseTo(75000.0, offset(DELTA));
    }

    @Test
    void testCalculateTax_Tier3() {
        assertThat(TaxCalculator.calculateTax(750000.0)).isCloseTo(150000.0, offset(DELTA));
        assertThat(TaxCalculator.calculateTax(1000000.0)).isCloseTo(200000.0, offset(DELTA));
    }

    @Test
    void testCalculateTax_Tier4() {
        assertThat(TaxCalculator.calculateTax(1500000.0)).isCloseTo(375000.0, offset(DELTA));
    }

    @Test
    void testCalculateTax_ZeroIncome() {
        assertThat(TaxCalculator.calculateTax(0.0)).isCloseTo(0.0, offset(DELTA));
    }

    @Test
    void testCalculateTax_NegativeIncome() {
        assertThat(TaxCalculator.calculateTax(-10000.0)).isCloseTo(-1.0, offset(DELTA));
        assertThat(TaxCalculator.calculateTax(-0.01)).isCloseTo(-1.0, offset(DELTA));
    }
}