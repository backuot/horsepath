package com.knightmoves.controllers;

import org.springframework.stereotype.Component;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import static com.knightmoves.services.ChessKnight.count;
import static com.knightmoves.services.ChessKnight.getXCoordinate;
import static com.knightmoves.services.ChessKnight.getYCoordinate;

@Component
@Path("/")
public class ServletController {
    @GET
    @Path("/count")
    @Produces("text/plain")
    public Response getCount(@QueryParam("width") int width,
                             @QueryParam("height") int height,
                             @QueryParam("start") String start,
                             @QueryParam("end") String end) {
        return Response.status(Response.Status.OK)
                .entity(String.valueOf(count(width, height,
                    getXCoordinate(start),
                    getYCoordinate(start),
                    getXCoordinate(end),
                    getYCoordinate(end))))
                .build();
    }
}
