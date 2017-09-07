package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller.subresource;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Subresource;

@Component
@Produces(APPLICATION_JSON)
public class SubresourceController {
    @GET
    @Path("/{subresourceId}")
    public Subresource getSubresource(@PathParam("resourceId") String resourceId, @PathParam("subresourceId") String subresourceId) {
        Subresource subresource = new Subresource();
        subresource.setId(subresourceId);
        subresource.setResourceId(resourceId);
        // TRORLOR
        return subresource;
    }

    public void lol() {
        // sdofsdfopdsfpdfsp
    }
}
