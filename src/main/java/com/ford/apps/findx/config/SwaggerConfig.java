
package com.ford.apps.findx.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("X-Author-Token")
            .description("token")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(true)
            .build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.ford.apps.findx.web.controller"))
            .paths(PathSelectors.ant("/api/**"))
            .build()
            .globalOperationParameters(pars)
            .groupName("ford-findx")
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Swagger2 for Ford Findx")
            .contact(new Contact("JITAO", "https://github.com/skymarlio82", "jitao.liu@aliyun.com"))
            .version("1.0")
            .build();
    }
}