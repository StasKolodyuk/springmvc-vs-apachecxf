package by.miniq.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;

import by.miniq.controller.subresource.SubresourceController;
import org.springframework.stereotype.Component;

import by.miniq.model.Resource;

@Component
@Path("/resources")
@Produces(APPLICATION_JSON)
public class ResourceController {
    @Context
    ResourceContext resourceContext;

    @GET
    @Path("/{resourceId}")
    public Resource getResource(@PathParam("resourceId") String resourceId) {
        Resource resource = new Resource();
        resource.setId(resourceId);

        return resource;
    }

    @Path("/{resourceId}/subresources/")
    public SubresourceController getSubresource() {
        return resourceContext.getResource(SubresourceController.class);
    }
}
