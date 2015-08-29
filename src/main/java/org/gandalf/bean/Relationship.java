package org.gandalf.bean;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity
public class Relationship {
	
	@StartNode 
	private Person personA;
	
    @EndNode 
    private Person personB;
    
    //关系 
    private String relationship;

	public Person getPersonA() {
		return personA;
	}

	public void setPersonA(Person personA) {
		this.personA = personA;
	}

	public Person getPersonB() {
		return personB;
	}

	public void setPersonB(Person personB) {
		this.personB = personB;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
}