package com.hongik.kiosk.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1-aikiosk")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI springAiKioskOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("AI-KIOSK API")
                        .description("AI-KIOSK API 명세서입니다.")
                        .version("v0.0.1")
                );
    }
}
