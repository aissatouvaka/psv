/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.resource;

import com.vetisolutions.smartcal.administrationmanager.service.EnseignantService;
import com.vetisolutions.smartcalc.entities.Enseignant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 *
 * @author vaka
 */

@Component
@Path("/Enseignant")
@Api(value="module de gestion des enseignants")
public class EnseignantResource {
    
    @Autowired
    private EnseignantService enseignantService;
    
    @ApiOperation(value = "Add a teacher ", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Teacher added successfully"),
        @ApiResponse(code = 403 , message = "Adding teacher to fail!")
    })
    @POST
    @Path("/ajoutEnseignant")
    @Consumes(value= MediaType.APPLICATION_JSON)
    @Produces(value= MediaType.APPLICATION_JSON)
    public Enseignant ajoutEnseignant(Enseignant en){
        return enseignantService.create(en);
    }
    
    @ApiOperation(value = "Allows you to modify the characteristics of a teacher", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Teacher modification successfully"),
        @ApiResponse(code = 403, message = "Modifying teacher to fail!")
    })
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Enseignant modifierEnseignant(@PathParam("id") Long id, Enseignant en){
        return enseignantService.update(en);
    }
    
    @ApiOperation(value = "Displays the list of teachers", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful teachers"),
        @ApiResponse(code = 403, message = "Failed teacher list!")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page<Enseignant> returnAll(@DefaultValue("0") @QueryParam("from")int from,
            @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return enseignantService.findAll(from, to);
    }
    
    @ApiOperation(value = "Allows you to delete a teacher", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Teacher deleted"),
        @ApiResponse(code = 403, message = "Teacher deletion failed!")
    })
    @DELETE
    @Path("{id}")
    public void supprimerEnseignant(@PathParam("id") Long id){
        enseignantService.delete(id);
    }
    
}
