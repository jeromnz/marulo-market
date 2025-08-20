package com.plansoft.marulo_market.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info()
                        .title("Marulo Market API")
                        .version("1.0.0")
                        .description("Documentación generada con Springdoc OpenAPI para Marulo Market")
                );
    }
}
