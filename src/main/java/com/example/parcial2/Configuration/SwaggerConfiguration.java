package com.example.parcial2.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API PARCIAL 2")
                        .version("1.0")
                        .description("Documentación de la API del Parcial 2")
                        .contact(new Contact()
                                .name("Juan David Ramírez")
                                .email("jdramirezsantana@ucundinamarca.edu.co")));
    }
}