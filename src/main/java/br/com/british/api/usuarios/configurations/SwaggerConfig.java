package br.com.british.api.usuarios.configurations;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI customOpenApi() {
        OpenAPI openAPI = new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))) // Configurando autenticação JWT
                .info(new Info()
                        .title("API de Controle de Usuários")
                        .description("API RESTful para gerenciamento de usuários e perfis.")
                        .version("v1")
                        .contact(new Contact()
                                .name("Equipe de Suporte")
                                .email("suporte@british.com")
                                .url("https://www.british.com"))
                        .termsOfService("https://www.british.com/terms")
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))) // Informações da API
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth")); // Adicionando o esquema de segurança

        return openAPI;
    }
}
