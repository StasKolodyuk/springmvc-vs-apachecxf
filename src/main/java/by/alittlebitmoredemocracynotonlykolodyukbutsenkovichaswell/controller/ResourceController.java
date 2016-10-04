package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(path = "/resources")
public class ResourceController
{
    @GetMapping(path = "/{resourceId}")
    public Callable<Resource> getResource(@PathVariable String resourceId)
    {
        Resource resource = new Resource();
        resource.setId(resourceId);

        return () -> resource;
    }
}
