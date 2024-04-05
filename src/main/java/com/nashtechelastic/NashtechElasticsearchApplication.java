package com.nashtechelastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = "com.nashtechelastic.repository")
public class NashtechElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(NashtechElasticsearchApplication.class, args);
	}

}
