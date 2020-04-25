/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.resource;

import com.vetisolutions.smartcal.administrationmanager.service.UtilisateurService;
import com.vetisolutions.smartcalc.entities.Utilisateur;
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
@Path("/Utilisateur")
@Api(value="module de gestion des utilisateurs")
public class UtilisateurResource {
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @ApiOperation(value = "Add a user ", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User added successfully"),
        @ApiResponse(code = 403 , message = "Adding user to fail!")
    })
    @POST
    @Path("/ajoutUtilisateur")
    @Consumes(value= MediaType.APPLICATION_JSON)
    @Produces(value= MediaType.APPLICATION_JSON)
    public Utilisateur ajoutUtilisateur(Utilisateur u){
        return utilisateurService.create(u);
    }
    
    @ApiOperation(value = "Allows you to modify the characteristics of a user", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User modification successfully"),
        @ApiResponse(code = 403, message = "Modifying user to fail!")
    })
    @PUT    
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Utilisateur modifierUtilisateur(@PathParam("id") Long id, Utilisateur u){
        return utilisateurService.update(u);
    }
    
    @ApiOperation(value = "Displays the list of users", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful users"),
        @ApiResponse(code = 403, message = "Failed User list!")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page<Utilisateur> returnAll(@DefaultValue("0") @QueryParam("from")int from,
            @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return utilisateurService.findAll(from, to);
    }
    
    @ApiOperation(value = "Allows you to delete a user", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "User deleted"),
        @ApiResponse(code = 403, message = "User deletion failed!")
    })
    @DELETE
    @Path("{id}")
    public void supprimerUtilisateur(@PathParam("id") Long id){
        utilisateurService.delete(id);
    }
    
}
