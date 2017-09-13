package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Error;
import io.swagger.model.NewPet;
import io.swagger.model.Pet;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-13T09:12:18.683-04:00")
public abstract class PetsApiService {
    public abstract Response addPet(NewPet pet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePet(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findPetById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findPets( List<String> tags, Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePet(Long id,NewPet pet,SecurityContext securityContext) throws NotFoundException;
}
