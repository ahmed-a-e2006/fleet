package com.fleet.daos.orm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_table")
public class TestEntity {
	
	@Id
	private long id;
	
	private String name;
	
	public TestEntity() {
		
	}
	
	public TestEntity(long id, String name) {
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