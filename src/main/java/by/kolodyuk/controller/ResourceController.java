package by.kolodyuk.controller;

import by.kolodyuk.model.Resource;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/resources")
@Produces(APPLICATION_JSON)
public class ResourceController {

    @GET
    @Path("/{resourceId}")
    public Resource getResource(@PathParam("resourceId") String resourceId) {
        Resource resource = new Resource();
        resource.setId(resourceId);

        return resource;
    }
}
