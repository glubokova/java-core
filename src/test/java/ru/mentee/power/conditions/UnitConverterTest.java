package ru.mentee.power.conditions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class UnitConverterTest {

    private UnitConverter converter;
    private static final double DELTA = 0.001;
    private static final double ERROR = -1.0;
    @BeforeEach
    void setUp() {
        converter = new UnitConverter();
    }

    @Test
    @DisplayName("Конвертация из метров в сантиметры")
    void convertMetresToCentimetres() {
        double value = 1.0;
        String fromUnit = "Метр";
        String toUnit = "Сантиметр";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(100.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из сантиметров в метры")
    void convertCentimetresToMetres() {
        double value = 150.0;
        String fromUnit = "Сантиметр";
        String toUnit = "Метр";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(1.5, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из метров в футы")
    void convertMetresToFeet() {
        double value = 2.0;
        String fromUnit = "Метр";
        String toUnit = "Фут";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(6.56, within(DELTA)); // В этой строке ошибка!
    }

    @Test
    @DisplayName("Конвертация из килограммов в граммы")
    void convertKilogramsToGrams() {
        double value = 2.5;
        String fromUnit = "Килограмм";
        String toUnit = "Грамм";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(-1.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из фунтов в унции")
    void convertPoundsToOunces() {
        double value = 1.0;
        String fromUnit = "Фунт";
        String toUnit = "Унция";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(-1.0, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из Цельсия в Фаренгейт")
    void convertCelsiusToFahrenheit() {
        double value = 25.0;
        String fromUnit = "Цельсий";
        String toUnit = "Фаренгейт";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        double expectedValue = (25.0 * 9.0 / 5.0) + 32.0;
        assertThat(convertedValue).isCloseTo(expectedValue, within(DELTA));
    }

    @Test
    @DisplayName("Конвертация из Фаренгейта в Кельвин")
    void convertFahrenheitToKelvin() {
        double value = 32.0;
        String fromUnit = "Фаренгейт";
        String toUnit = "Кельвин";
        double convertedValue = converter.convert(value, fromUnit, toUnit);
        assertThat(convertedValue).isCloseTo(273.15, within(DELTA));
    }

    @Test
    @DisplayName("Обработка несовместимых единиц измерения")
    void handleIncompatibleUnits() {
        double value = 10.0;
        String fromUnit = "Метр";
        String toUnit = "Килограмм";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isEqualTo(-1.0);
    }

    @Test
    @DisplayName("Обработка неподдерживаемых единиц измерения (fromUnit)")
    void handleUnsupportedFromUnit() {
        double value = 10.0;
        String fromUnit = "Миля";
        String toUnit = "Метр";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isEqualTo(-1.0);
    }

    @Test
    @DisplayName("Обработка неподдерживаемых единиц измерения (toUnit)")
    void handleUnsupportedToUnit() {
        double value = 10.0;
        String fromUnit = "Метр";
        String toUnit = "Ярд";
        double result = converter.convert(value, fromUnit, toUnit);
        assertThat(result).isEqualTo(ERROR);
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, METER, CENTIMETER, 100.0",
            "100.0, CENTIMETER, METER, 1.0",
            "1.0, KILOGRAM, POUND, 2.20462",
            "1.0, POUND, KILOGRAM, 0.45359",
            "0.0, CELSIUS, FAHRENHEIT, 32.0",
            "273.15, KELVIN, CELSIUS, 0.0",
            "5.0, METER, INCH, 196.85",
            "10.0,  KILOGRAM, OUNCE, -1.0"
    })
    @DisplayName("Параметризованные тесты конвертаций")
    void testVariousConversions(double value, String fromUnit, String toUnit, double expected) {
        String from = getUnitConstant(fromUnit);
        String to = getUnitConstant(toUnit);
        double convertedValue = converter.convert(value, from, to);
        assertThat(convertedValue)
                .as("Конвертация %f %s в %s".formatted(value, from, to))
                .isCloseTo(expected, within(DELTA));
    }

    private String getUnitConstant(String unitName) {
        return switch (unitName) {
            case "METER" -> UnitConverter.METER;
            case "CENTIMETER" -> UnitConverter.CENTIMETER;
            case "INCH" -> UnitConverter.INCH;
            case "FOOT" -> UnitConverter.FOOT;
            case "KILOGRAM" -> UnitConverter.KILOGRAM;
            case "GRAM" -> UnitConverter.GRAM;
            case "POUND" -> UnitConverter.POUND;
            case "OUNCE" -> UnitConverter.OUNCE;
            case "CELSIUS" -> UnitConverter.CELSIUS;
            case "FAHRENHEIT" -> UnitConverter.FAHRENHEIT;
            case "KELVIN" -> UnitConverter.KELVIN;
            default -> throw new IllegalArgumentException("Unknown unit: " + unitName);
        };
    }
}