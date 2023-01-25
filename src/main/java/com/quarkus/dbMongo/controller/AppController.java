package com.quarkus.dbMongo.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.quarkus.dbMongo.model.PersonDocument;
import com.quarkus.dbMongo.services.impl.PersonService;
import org.bson.types.ObjectId;

@Path("/v1")
public class AppController {
    @Inject
    PersonService service;

    @Path("AllPerson")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok("Todos los registros").entity(service.findAll()).build();
    }

    @Path("Person/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") ObjectId id) {
        return Response.ok().entity(service.findById(id)).build();
    }

    @Path("SavePerson")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response savePerson(PersonDocument personDocument) {
        return Response.ok(service.SavePerson(personDocument)).build();
    }

    @Path("UpdatePerson")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(PersonDocument personDocument){
        service.update(personDocument);
        return Response.ok("Actualizado correctamente")
                .entity(service.findById(personDocument.getId()))
                .build();
    }
}