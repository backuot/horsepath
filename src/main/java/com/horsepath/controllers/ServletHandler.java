package com.horsepath.controllers;

import org.springframework.stereotype.Component;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Component
@Path("/")
public class ServletHandler {
    @GET
    @Path("/count")
    @Produces("text/plain")
    public String getCount(@QueryParam("width") int width,
                           @QueryParam("height") int height,
                           @QueryParam("start") String start,
                           @QueryParam("end") String end) {
        return "It's JAX-RS " + width + " " + height + " " + start + " " + end;
    }
}
