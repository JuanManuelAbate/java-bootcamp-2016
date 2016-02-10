package controller;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Class to configure Swagger 2
 * 
 * @author Juan Manuel Abate
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api-shoppingCart").apiInfo(apiInfo())
				.directModelSubstitute(LocalDateTime.class, Date.class).select().paths(regex("/shoppingCart.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ShoppingCart").description("ShoppingCart REST api").contact("juan.abate@gmail.com")
				.license("Apache License Version 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0").build();
	}
}
