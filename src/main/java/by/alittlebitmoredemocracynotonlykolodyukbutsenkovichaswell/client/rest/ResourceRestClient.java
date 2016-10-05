package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest.model.ResourceResponse;

public class ResourceRestClient {
    private WebClient webClient;

    private static final String RESOURCE_DESCRIPTION = " resource description";


    @Autowired
    public ResourceRestClient(WebClient webClient)
    {
        this.webClient = webClient;
    }


    public String getResourceDescription(String resourceId)
    {
        webClient.replacePath(resourceId + RESOURCE_DESCRIPTION);
        ResourceResponse resourceResponse = webClient.get(ResourceResponse.class);
        return resourceResponse.getDescription().replace("%20", " ");
    }
}
