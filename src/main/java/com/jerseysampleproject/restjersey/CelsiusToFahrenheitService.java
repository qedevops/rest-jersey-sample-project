package com.jerseysampleproject.restjersey;

import com.jerseysampleproject.events.Temperature;
import com.jerseysampleproject.services.Convert;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/c2f")
public class CelsiusToFahrenheitService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Temperature convertCtoF() {

        Double celsius = 36.8;
        Temperature temperature = new Temperature("celsius", celsius);

        return Convert.convertCelsiusAndFahrenheit(temperature);
    }

    @Path("{c}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Temperature convertCtoFFromInput(@PathParam("c") Double c) {
        Temperature temperature = new Temperature("celsius", c);
        ;

        return Convert.convertCelsiusAndFahrenheit(temperature);
    }

    @POST
    @Path("/convert")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Temperature createTrackInJSON(Temperature temperature) {

        return Convert.convertCelsiusAndFahrenheit(temperature);

    }

}
