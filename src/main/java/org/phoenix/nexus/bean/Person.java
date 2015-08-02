package org.phoenix.nexus.bean;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Person {
	
	@GraphId
	private Long id;
	
	private String name;
	
	public Person() {}
	
	public Person(long id, String name) {
		
        this.id = id;
        this.name = name;
    }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
