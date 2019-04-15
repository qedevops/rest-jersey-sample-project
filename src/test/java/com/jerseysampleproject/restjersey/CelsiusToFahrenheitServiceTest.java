package com.jerseysampleproject.restjersey;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CelsiusToFahrenheitServiceTest {

    private CelsiusToFahrenheitService celsiusToFahrenheitService;

    @Before
    public void init() {
        celsiusToFahrenheitService = new CelsiusToFahrenheitService();
    }

    @Test
    public void shouldBeAbleToGetDefaultValueFromCelsiusToFahrenheit() {
        Double expectedVal = 98.24;
        assertEquals(expectedVal, celsiusToFahrenheitService.convertCtoF().getValue());
    }

    @Test
    public void shouldBeAbleToConvertUserInputFromCelsiusToFahrenheit() {
        double celsius = 0;
        Double expectedVal = 32.0;
        assertEquals(expectedVal, celsiusToFahrenheitService.convertCtoFFromInput(celsius).getValue());
    }

}
