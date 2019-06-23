package com.knightmoves.controllers;

import org.springframework.stereotype.Component;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import static com.knightmoves.services.ChessKnight.getXCoordinate;
import static com.knightmoves.services.ChessKnight.getYCoordinate;
import static com.knightmoves.services.ChessKnight.count;
import static com.knightmoves.services.ChessKnight.valid;

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
        if (width < 3)
            return Response.status(Response.Status.BAD_REQUEST).entity("Not valid width.").build();
        if (height < 3)
            return Response.status(Response.Status.BAD_REQUEST).entity("Not valid height.").build();

        int x1 = getXCoordinate(start);
        int y1 = getYCoordinate(start);
        int x2 = getXCoordinate(end);
        int y2 = getYCoordinate(end);

        if (!valid(x1, y1, width, height))
            return Response.status(Response.Status.BAD_REQUEST).entity("Not valid start.").build();
        if (!valid(x2, y2, width, height))
            return Response.status(Response.Status.BAD_REQUEST).entity("Not valid end.").build();

        return Response.status(Response.Status.OK).entity(String.valueOf(count(x1, y1, x2, y2, width, height))).build();
    }
}