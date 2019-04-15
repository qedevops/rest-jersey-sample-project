package com.jerseysampleproject.services;

        import com.jerseysampleproject.events.Temperature;

public class Convert {

    public static Temperature convertCelsiusAndFahrenheit(Temperature temperature) {

        String measurement = temperature.getMeasure().trim();
        double units = temperature.getValue();

        String newMeasurement = null;
        double newUnits = 0.0;

        if (measurement.equalsIgnoreCase("celsius")) {
            newMeasurement = "fahrenheit";
            newUnits = ((units * 9) / 5) + 32;
        } else if (measurement.equalsIgnoreCase("fahrenheit")) {
            newMeasurement = "celsius";
            newUnits = (units - 32) * 5 / 9;
        }

        return new Temperature(newMeasurement, newUnits);
    }
}
