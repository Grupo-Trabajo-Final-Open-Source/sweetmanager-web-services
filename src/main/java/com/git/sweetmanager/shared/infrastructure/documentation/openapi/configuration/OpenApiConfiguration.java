package com.git.sweetmanager.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI sweetManagerPlatformOpenApi(){
        // General Configuration
        var openAPI = new OpenAPI();

        openAPI.info(new Info()
                .title("Sweet Manager Platform API")
                .description("Sweet Manager Platform API Documentation")
                .version("1.0.0")
                .license(new License().name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Sweet Manager Platform Wiki Documentation")
                        .url("https://sweetmanager-platform.wiki.github.io/docs"));

        return openAPI;
    }
}
