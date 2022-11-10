package edu.upc.dsa.services;


import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Game;
import edu.upc.dsa.models.Partida;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/games", description = "Endpoint to Game Service")
@Path("/games")
public class GamesService {

    private GameManager gm;

    public GamesService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.size()==0) {
            this.gm.addGame("game0001", "first game", 1);
            this.gm.initGame("game0001", "user0258");
        }
    }

    @GET
    @ApiOperation(value = "get all Games", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Game.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllGames() {

        List<Game> tracks = this.gm.findAllGames();

        GenericEntity<List<Game>> entity = new GenericEntity<List<Game>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Game by User id", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Game.class),
            @ApiResponse(code = 404, message = "User id not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGame(@PathParam("id") String id) {
        List<Game> g = this.gm.findAll(id);
        if (g == null) return Response.status(404).build();
        else  return Response.status(201).entity(g).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Game not found")
    })
    @Path("/{id}")
    public Response deleteGame(@PathParam("id") String id) {
        List<Game> g = this.gm.findAllGames();
        if (g == null) return Response.status(404).build();
        else this.gm.deleteGame(id);
        return Response.status(201).build();
    }
/**
    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }

    **/



}