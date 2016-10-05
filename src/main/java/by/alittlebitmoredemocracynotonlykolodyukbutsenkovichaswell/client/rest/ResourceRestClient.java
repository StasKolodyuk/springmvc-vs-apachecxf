package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest;

import by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest.model.ResourceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResourceRestClient {
    private RestTemplate restTemplate;

    private static final String SERVICE_URL = "http://echo.jsontest.com/description/";
    private static final String RESOURCE_DESCRIPTION = " resource description";


    @Autowired
    public ResourceRestClient(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }


    public String getResourceDescription(String resourceId)
    {
        ResourceResponse resourceResponse = restTemplate.getForObject(SERVICE_URL + resourceId + RESOURCE_DESCRIPTION, ResourceResponse.class);
        return resourceResponse.getDescription().replace("%20", " ");
    }
}
