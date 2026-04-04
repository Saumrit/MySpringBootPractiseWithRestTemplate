package com.saumrit.restclientdemo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    public OpenAPI MySpringBootSwaggerDemo(){
        return new OpenAPI()
                .info(new Info().title("Sample Programme for  SpringBoot with RestTemplate")
                        .description("It is a demo project to show RestTemplate , RestClient usage in SpringBoot"));

    }
}
