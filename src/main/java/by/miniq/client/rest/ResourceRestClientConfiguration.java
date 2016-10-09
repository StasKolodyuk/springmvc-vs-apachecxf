package by.miniq.client.rest;

import by.kolodyuk.logging.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static java.util.Arrays.asList;

@Configuration
public class ResourceRestClientConfiguration
{
    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(asList(new LoggingInterceptor()));

        return restTemplate;
    }
}
