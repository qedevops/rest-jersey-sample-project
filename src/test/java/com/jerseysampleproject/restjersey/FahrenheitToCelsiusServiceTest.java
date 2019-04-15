package com.jerseysampleproject.restjersey;

import com.jerseysampleproject.events.TemperatureWrapper;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FahrenheitToCelsiusServiceTest {

    private FahrenheitToCelsiusService fahrenheitToCelsiusService;

    @Before
    public void init() {
        fahrenheitToCelsiusService = new FahrenheitToCelsiusService();
    }

    @Test
    public void shouldBeAbleToGetDefaultValueFromFahrenheitToCelsius() {

        assertEquals(200, fahrenheitToCelsiusService.convertFtoC().getStatus());
    }

    @Test
    public void shouldBeAbleToConvertUserInputFromFahrenheitToCelsius() {
        Response response = fahrenheitToCelsiusService.convertFtoCFromInput(41);

        assertEquals(200, response.getStatus());
        TemperatureWrapper responseEntity = (TemperatureWrapper) response.getEntity();

        assertNotNull(responseEntity.getTemperature());
        assertEquals((Double) 5.0, responseEntity.getTemperature().getValue());
        assertEquals("celsius", responseEntity.getTemperature().getMeasure());
    }


}
