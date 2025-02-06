package com.natixis.EasyPay;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
		info = @Info(
				title = "EasyBank REST API Documentation",
				description = "Documentation for the EasyBank REST API, providing endpoints to calculate final values and schedule date of the transaction.",
				version = "v1",
				contact = @Contact(
						name = "Lucas Andrade",
						email = "rissiandrade@gmail.com"
				),
				license = @License(
						name = "Apache License 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0.html"
				)
		)
)

@SpringBootApplication
public class EasyPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyPayApplication.class, args);
	}

}
