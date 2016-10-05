package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest;

import java.util.Arrays;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class ResourceRestClientConfiguration
{
    private String JSONTEST_SERVICE_URL = "http://echo.jsontest.com/description/";


    @Bean
    public WebClient webClient()
    {
        WebClient webClient = WebClient.create(JSONTEST_SERVICE_URL,
                Arrays.asList(new JacksonJsonProvider(objectMapper())), true);
        return webClient;
    }


    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper();
    }
}
