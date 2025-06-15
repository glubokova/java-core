package ru.mentee.power.variables;

public class TemperatureConverter {
    public static final double ABSOLUTE_ZERO_CELSIUM = -273.15;

    public static void main(String[] args) {
        double temperatureCelsius = 25.0;

        double temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32;

        double temperatureKelvin = temperatureCelsius + 273.15;

        System.out.println(temperatureCelsius + " °C = " + temperatureFahrenheit + " °F");
        System.out.println(temperatureCelsius + " °C = " + temperatureKelvin + " K");
    }
}