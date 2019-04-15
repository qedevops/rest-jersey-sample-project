package com.jerseysampleproject.restjersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jerseysampleproject.events.TemperatureWrapper;
import com.jerseysampleproject.events.Temperature;
import com.jerseysampleproject.services.Convert;
import org.json.JSONException;

@Path("/f2c")
public class FahrenheitToCelsiusService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertFtoC() throws JSONException {

        Double fahrenheit = 98.24;

        Temperature temperature = new Temperature("fahrenheit", fahrenheit);

        TemperatureWrapper temperatureWrapper = new TemperatureWrapper();
        temperatureWrapper.setTemperature(Convert.convertCelsiusAndFahrenheit(temperature));

        return Response.status(200).entity(temperatureWrapper).build();
    }

    @Path("{f}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertFtoCFromInput(@PathParam("f") float f) throws JSONException {

        Temperature temperature = new Temperature("fahrenheit", (double) f);

        TemperatureWrapper temperatureWrapper = new TemperatureWrapper();
        temperatureWrapper.setTemperature(Convert.convertCelsiusAndFahrenheit(temperature));

        return Response.status(200).entity(temperatureWrapper).build();
    }

    @POST
    @Path("/convert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Temperature temperature) {

        TemperatureWrapper temperatureWrapper = new TemperatureWrapper();
        temperatureWrapper.setTemperature(Convert.convertCelsiusAndFahrenheit(temperature));

        return Response.status(201).entity(temperatureWrapper).build();

    }


}
