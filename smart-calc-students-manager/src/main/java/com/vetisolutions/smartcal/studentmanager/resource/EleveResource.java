/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.studentmanager.resource;

import com.vetisolutions.smartcal.studentmanager.service.EleveService;
import com.vetisolutions.smartcal.studentmanager.smartcalcstudentmanager.utils.UtilsService;
import com.vetisolutions.smartcalc.entities.Eleve;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Date;
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
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 *
 * @author vaka
 */

@Component
@Path("/Eleve")
@Api(value="module de gestion des élèves")
public class EleveResource {
    
    @Autowired
    public EleveService eleveService;
    
    @Autowired
    private UtilsService utilsService;
    
    @ApiOperation(value = "Add a student ", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Student added successfully"),
        @ApiResponse(code = 403 , message = "Adding student fail!")
    })
    @POST
    @Path("/ajoutEleve")
    @Consumes(value= MediaType.APPLICATION_JSON)
    @Produces(value= MediaType.APPLICATION_JSON)
    public Eleve ajoutEleve(Eleve e){
        return eleveService.create(e);
    }
    
    @ApiOperation(value = "Displays the list of students", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful students"),
        @ApiResponse(code = 403, message = "Failed student list!")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page<Eleve> returnAll(@DefaultValue("0") @QueryParam("from")int from,
            @DefaultValue("50") @QueryParam("to") int to){
        return eleveService.findAll(from, to);
    }
    
    @ApiOperation(value = "Displays the list of students with a specific date of birth", response = Page.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful students"),
        @ApiResponse(code = 403, message = "Failed student list!")
    })
    @GET
    @Path("/date/{birthDate}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Eleve> returnAllByBirthDate(@PathParam("date") String birthDate, @DefaultValue("0") @QueryParam("from")int from, @DefaultValue("50") @QueryParam("to")int to){
        Date date = utilsService.convertStringToDate(birthDate);
        return eleveService.findAllByBirthDate(date, from, to);
    }
    
    @ApiOperation(value = "Displays the list of students with a specific place of birth", response = Page.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful students"),
        @ApiResponse(code = 403, message = "Failed student list!")
    })
    @GET
    @Path("/date/{birthDate}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Eleve> returnAllByBirthPlace(@PathParam("place") String birthPlace, @DefaultValue("0") @QueryParam("from")int from, @DefaultValue("50") @QueryParam("to")int to){
        return eleveService.findAllByBirthPlace(birthPlace, from, to);
    }
    
    @ApiOperation(value = "Displays the list of students with the specified tutor name", response = Page.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful students"),
        @ApiResponse(code = 403, message = "Failed students list!")
    })
    @GET
    @Path("/tutor/{tutorName}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Eleve> returnAllByTutorName(@PathParam("tutor") String tutorName, @DefaultValue("0") @QueryParam("from")int from, @DefaultValue("50") @QueryParam("to")int to){
        return eleveService.findAllByTutorName(tutorName, from, to);
    }
    
    @ApiOperation(value = "Displays the list of students with the specificied register number", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lists of successful students"),
        @ApiResponse(code = 403, message = "Failed student list!")
    })
    @GET
    @Path("/number/{registerNumber}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Eleve returnOneByRegisterNumber(@PathParam("number") String registerNumber){
        return eleveService.findOneByRegisterNumber(registerNumber);
    }
    
    @ApiOperation(value = "Displays the list of students with the specified date and place of birth", response = Page.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " student research successfully"),
        @ApiResponse(code = 403, message = "Failed to research student!")
    })
    @GET
    @Path("/dateplace/{birthDate}/{birthPlace}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Eleve> returnAllByBirthDateAndBirthPlace(@PathParam("date") String birthDate, @PathParam("place") String birthPlace, @DefaultValue("0") @QueryParam("from")int from, @DefaultValue("50") @QueryParam("to")int to){
        Date date = utilsService.convertStringToDate(birthDate);
        return eleveService.findAllByBirthDateAndBirthPlace(date, birthPlace, from, to);
    }
    
    @ApiOperation(value = "Allows you to modify the characteristics of a student", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Student modification successfully"),
        @ApiResponse(code = 403, message = "Modifying student to fail!")
    })
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Eleve modifierEleve(@PathParam("id") Long id, Eleve e){
        return eleveService.update(e);
    }

    @ApiOperation(value = "Allows you to delete a student", response = Response.class)
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Student deleted"),
        @ApiResponse(code = 403, message = "Student deletion failed!")
    })
    @DELETE
    @Path("{id}")
    public void supprimerEleve(@PathParam("id") Long id){
        eleveService.delete(id);
    }
}
