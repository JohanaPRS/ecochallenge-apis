package com.backend.jwt.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger3Config {
    @Bean
    public Docket produceApi() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        parameterBuilder.name("Authorization") // Updates the parameter name
                .description("JSON Web Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                // Sets the api's meta information as included in the json ResourceListing response.
                .apiInfo(apiInfo())
                // Initiates a builder for api selection.
                .select()
                // Any RequestHandler satisfies this condition
                .apis(RequestHandlerSelectors.any())
                // Any path satisfies this condition
                .paths(PathSelectors.any())
                .build()
                // Adds default parameters which will be applied to all operations.
                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() // Builds the api information
                .title("Spring Boot API Document")
                .description("")
                .version("1.0.0")
                .build();
    }
}

