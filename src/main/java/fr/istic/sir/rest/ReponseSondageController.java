package fr.istic.sir.rest;

import dao.ReponseSondageDAO;
import entities.ReponseSondage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/sondage")
public class ReponseSondageController {
    private ReponseSondageDAO dao;

    public ReponseSondageController(){
        dao = new ReponseSondageDAO();
    }

    @GET
    @Path("/responses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReponseSondage> getAllResponses(){
        List<ReponseSondage> rep = dao.allReponseSondage();
        for (ReponseSondage r : rep) {
            r.setSondage(null);
        }
        return rep;
    }
}
