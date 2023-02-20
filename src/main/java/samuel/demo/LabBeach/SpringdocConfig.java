package samuel.demo.LabBeach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {

	@Bean
	public OpenAPI baseOpenAPI() {
		
		ApiResponse badRequestAPI = new ApiResponse().content(
				new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
						new MediaType().addExamples("default",
								new Example().value("{\"code\": 400, \"Status\" : \"Bad Request!\", \"Message\": \"Bad Request\"}")
				)
			)
		);
		
		ApiResponse internalServerErrorAPI = new ApiResponse().content(
				new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
						new MediaType().addExamples("default",
								new Example().value("{\"code\": 500, \"Status\" : \"internal Server Error!\", \"Message\": \"internal Server Error\"}")
				)
			)
		);
		
		ApiResponse sucessAPI = new ApiResponse().content(
				new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
						new MediaType().addExamples("default",
								new Example().value("{\"code\": 200, \"Status\" : \"Ok!\", \"Message\": \"Complet\"}")
				)
			)
		);
		
		Components components = new Components();
		components.addResponses("badRequestAPI", badRequestAPI);
		components.addResponses("internalServerErrorAPI", internalServerErrorAPI);
		components.addResponses("sucessAPI", sucessAPI);
		
		return new OpenAPI()
				.components(components)
				.info(
			new Info().title("Documentação Swagger").version("1.0.1").description("DOcumentação de Api com Swagger")
		);
	}
}