package io.swagger.api.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.PetsApiService;
import io.swagger.model.NewPet;
import io.swagger.model.Pet;
import jersey.repackaged.com.google.common.collect.Lists;
import jersey.repackaged.com.google.common.collect.Maps;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-18T12:30:09.055-04:00")
public class PetsApiServiceImpl extends PetsApiService {

	Map<Long, Pet> pets = Maps.newHashMap();
	long nextId = 0L;

	@Override
	public Response addPet(NewPet pet, SecurityContext securityContext) throws NotFoundException {
		Pet petToAdd = new Pet();
		petToAdd.setId(nextId++);
		petToAdd.setTag(pet.getTag());
		petToAdd.setName(pet.getName());
		pets.put(petToAdd.getId(), petToAdd);
		return Response.ok().entity(petToAdd).build();
	}

	@Override
	public Response deletePet(Long id, SecurityContext securityContext) throws NotFoundException {
		if (pets.containsKey(id)) {
			pets.remove(id);
			return Response.noContent().build();
		} else {
			return noSuchPet(id);
		}
	}

	@Override
	public Response findPetById(Long id, SecurityContext securityContext) throws NotFoundException {
		if (pets.containsKey(id)) {
			return Response.ok().entity(pets.get(id)).build();
		} else {
			return noSuchPet(id);
		}
	}

	@Override
	public Response findPets(List<String> tags, Integer limit, SecurityContext securityContext)
			throws NotFoundException {
		List<Pet> found = Lists.newArrayList();
		for (Pet pet: pets.values()) {
			if (limit != null && found.size() >= limit) {
				break;
			} else if (tags == null || tags.isEmpty() || tags.contains(pet.getTag())) {
				found.add(pet);
			}
		}
		return Response.ok().entity(found).build();
	}

	private Response noSuchPet(Long id) {
		return Response.status(404).entity(JsonNodeFactory.instance.textNode("No pet with id " + id)).build();
	}
}
