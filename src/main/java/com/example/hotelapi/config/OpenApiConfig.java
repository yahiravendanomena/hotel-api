package com.example.hotelapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hotelAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Hotel API")

                        .version("1.0")

                        .description("API REST para la gestión de habitaciones y reservaciones.")

                        .contact(new Contact()
                                .name("Yahir Avendaño")
                                .email("04menayahir@gmail.com")));

    }

}