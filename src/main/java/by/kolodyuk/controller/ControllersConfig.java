package by.kolodyuk.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllersConfig {

    @Bean
    JacksonJsonProvider jacksonJsonProvider() {
        return new JacksonJsonProvider();
    }
}
