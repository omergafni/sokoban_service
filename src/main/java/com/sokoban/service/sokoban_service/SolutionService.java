package com.sokoban.service.sokoban_service;

import com.sokoban.service.db.DbHandler;
import com.sokoban.service.db.SokobanSolution;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("solutions")
public class SolutionService {

    private DbHandler dbHandler = new DbHandler();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSolution(@QueryParam("levelName") String levelName) {
        return dbHandler.getSolution(levelName);
    }

    @GET
    @Path("/add")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addSolution(@QueryParam("levelName") String levelName,@QueryParam("solution") String solution) {
        SokobanSolution sol = new SokobanSolution(levelName, solution);
        dbHandler.addSolution(sol);
    }


}
