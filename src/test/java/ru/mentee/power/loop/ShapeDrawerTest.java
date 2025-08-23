package ru.mentee.power.loop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeDrawerTest {

    private final ShapeDrawer drawer = new ShapeDrawer();

    @Test
    void testDrawSquare() {
        String expected = "***\n***\n***";
        String result = drawer.drawSquare(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawEmptysquare() {
        String expected = "***\n* *\n***";
        String result = drawer.drawEmptySquare(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawTriangle() {
        String expected = "*\n**\n***";
        String result = drawer.drawTriangle(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDrawRhombus() {
        String expected = " *\n***\n *";
        String result = drawer.drawRhombus(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testWithZeroOrNegativeSize() {
        assertThat(drawer.drawSquare(0)).isEmpty();
        assertThat(drawer.drawSquare(-5)).isEmpty();
        assertThat(drawer.drawEmptySquare(0)).isEmpty();
        assertThat(drawer.drawEmptySquare(-3)).isEmpty();
        assertThat(drawer.drawTriangle(0)).isEmpty();
        assertThat(drawer.drawTriangle(-2)).isEmpty();
        assertThat(drawer.drawRhombus(0)).isEmpty();
        assertThat(drawer.drawRhombus(-1)).isEmpty();
    }

    @Test
    void testWithLargeSize() {
        String square10 = drawer.drawSquare(10);
        assertThat(square10.split("\n").length).isEqualTo(10);

        String emptySquare10 = drawer.drawEmptySquare(10);
        assertThat(emptySquare10.split("\n").length).isEqualTo(10);

        String triangle10 = drawer.drawTriangle(10);
        assertThat(triangle10.split("\n").length).isEqualTo(10);

        String rhombus9 = drawer.drawRhombus(9);
        assertThat(rhombus9.split("\n").length).isEqualTo(9);
    }
    @Test
    void testRhombuswithEvenSize() {
        assertThat(drawer.drawRhombus(2)).isEqualTo(drawer.drawRhombus(3));
        assertThat(drawer.drawRhombus(4)).isEqualTo(drawer.drawRhombus(5));
        assertThat(drawer.drawRhombus(6)).isEqualTo(drawer.drawRhombus(7));
    }
}