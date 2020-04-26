package fr.istic.sir.rest;

import jpa.Reunion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    @GET
    @Path("/reunion")
    @Produces(MediaType.APPLICATION_JSON)
    public Reunion getReunion() {
        Reunion r = new Reunion();
        r.setId(1);
        return r;
    }
}



