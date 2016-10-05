package by.alittlebitmoredemocracynotonlykolodyukbutsenkovichaswell.client.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ResourceRestClientConfiguration
{
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
