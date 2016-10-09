package by.miniq.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import by.miniq.client.rest.model.ResourceResponse;

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
