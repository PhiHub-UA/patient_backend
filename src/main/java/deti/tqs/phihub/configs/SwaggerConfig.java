package deti.tqs.phihub.configs;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import io.swagger.v3.oas.models.OpenAPI;

@Generated
@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("phihub-api")
                .pathsToMatch("/**")
                .build();
    }


    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("PhiHUB")
                        .description("Description of the PhiHUB API.")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    

    }
    
}
