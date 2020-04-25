/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.resource;

import com.vetisolutions.smartcal.administrationmanager.service.ClasseService;
import com.vetisolutions.smartcalc.entities.Classe;
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
@Path("/Classe")
@Api(value="module de gestion des classes")
public class ClasseResource {
    
    @Autowired
    private ClasseService classeService;
    
    @ApiOperation(value = "Add a class ", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Class added successfully"),
        @ApiResponse(code = 403 , message = "Adding class fail!")
    })
    @POST
    @Path("/ajoutClasse")
    @Consumes(value= MediaType.APPLICATION_JSON)
    @Produces(value= MediaType.APPLICATION_JSON)
    public Classe ajoutClasse(Classe cl){
        return classeService.create(cl);
    }
    
    @ApiOperation(value = "Allows you to modify the characteristics of a class", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Class modification successfully"),
        @ApiResponse(code = 403, message = "Modifying class to fail!")
    })
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Classe modifierClasse(@PathParam("id") Long id, Classe cl){
        return classeService.update(cl);
    }
    
    @ApiOperation(value = "Displays the list of classes", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful classes"),
        @ApiResponse(code = 403, message = "Failed class list!")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page<Classe> returnAll(@DefaultValue("0") @QueryParam("from")int from,
            @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return classeService.findAll(from, to);
    }
    
    @ApiOperation(value = "Allows you to delete a class", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Class deleted"),
        @ApiResponse(code = 403, message = "Class deletion failed!")
    })
    @DELETE
    @Path("{id}")
    public void supprimerClasse(@PathParam("id") Long id){
        classeService.delete(id);
    }
    
}
