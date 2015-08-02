package org.phoenix.nexus;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@SpringBootApplication
@EnableNeo4jRepositories
public class Main extends Neo4jConfiguration {
	
	public Main() {
		setBasePackage("org.phoenix");
	}
	
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		
		return new GraphDatabaseFactory().newEmbeddedDatabase("E:/DataBase/Neo4j/data/test.db");
	}

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(Main.class, args);
	}
}
