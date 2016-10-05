package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller.subresource;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest.ResourceRestClient;
import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Subresource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(path = "/resources/{resourceId}/subresources")
public class SubresourceController
{
    private ResourceRestClient resourceRestClient;


    @Autowired
    public SubresourceController(ResourceRestClient resourceRestClient)
    {
        this.resourceRestClient = resourceRestClient;
    }


    @GetMapping(path = "/{subresourceId}")
    public Callable<Subresource> getSubresource(@PathVariable String resourceId, @PathVariable String subresourceId)
    {
        Subresource subresource = new Subresource();
        subresource.setId(subresourceId);
        subresource.setResourceId(resourceId);

        return () -> {
            String description = resourceRestClient.getResourceDescription(subresourceId);
            subresource.setDescription(description);
            return subresource;
        };
    }
}
