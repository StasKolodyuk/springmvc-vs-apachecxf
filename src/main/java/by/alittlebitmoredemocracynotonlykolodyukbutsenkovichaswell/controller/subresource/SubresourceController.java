package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.controller.subresource;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.model.Subresource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(path = "/resources/{resourceId}/subresources")
public class SubresourceController
{
    @GetMapping(path = "/{subresourceId}")
    public Callable<Subresource> getSubresource(@PathVariable String resourceId, @PathVariable String subresourceId)
    {
        Subresource subresource = new Subresource();
        subresource.setId(subresourceId);
        subresource.setResourceId(resourceId);

        return () -> subresource;
    }
}
