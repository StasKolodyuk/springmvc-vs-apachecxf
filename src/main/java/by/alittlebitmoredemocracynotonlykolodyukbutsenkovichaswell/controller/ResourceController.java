package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest.ResourceRestClient;
import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(path = "/resources")
public class ResourceController
{
    private ResourceRestClient resourceRestClient;


    @Autowired
    public ResourceController(ResourceRestClient resourceRestClient)
    {
        this.resourceRestClient = resourceRestClient;
    }


    @GetMapping(path = "/{resourceId}")
    public Callable<Resource> getResource(@PathVariable String resourceId)
    {
        Resource resource = new Resource();
        resource.setId(resourceId);

        return () -> {
            String description = resourceRestClient.getResourceDescription(resourceId);
            resource.setDescription(description);
            return resource;
        };
    }
}
