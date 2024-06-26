package com.git.sweetmanager.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI sweetManagerPlatformOpenApi(){
        // General Configuration
        var openAPI = new OpenAPI();

        openAPI.info(new Info()
                .title("Sweet Manager Platform API")
                .description("Sweet Manager Platform API Documentation")
                .version("v1.0.0")
                .license(new License().name("Apache 2.0")
                        .url("https://springdoc.orgl")))
                .externalDocs(new ExternalDocumentation()
                        .description("Sweet Manager Platform Wiki Documentation")
                        .url("https://sweetmanager-platform.wiki.github.io/docs"));


          openAPI.servers(List.of
                  (new Server()
                    .url("http://localhost:3453")
                    .description("Localhost Server"),
                new Server()
                        .url("https://sweetmanagerapi.ryzeon.me")
                        .description("Deploy Server")
          ));

        // Add security scheme

        final String securitySchemeName = "bearerAuth";

        openAPI.addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
        return openAPI;
    }
}
