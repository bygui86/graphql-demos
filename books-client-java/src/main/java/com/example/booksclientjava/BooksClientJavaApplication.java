package com.example.booksclientjava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BooksClientJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksClientJavaApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	CommandLineRunner run(GraphQLTemplate graphQLTemplate) {
		return args -> {

//			GraphQLResponse response = graphQLTemplate.perform("request.graphql", null,  null);
//			GraphQLResponse response = graphQLTemplate.perform("two-operation.graphql",
//					"BooksWithTitle", null);
//			GraphQLResponse response = graphQLTemplate.perform("two-operation.graphql",
//					"BooksWithTitleAndAuthor", null);
			GraphQLResponse response = graphQLTemplate.perform("addReview.graphql", null, null);

			System.out.println("Response:" + response.getResponseEntity().getBody());
			System.out.println("data:" + response.get("$.data"));

		};
	}
}
