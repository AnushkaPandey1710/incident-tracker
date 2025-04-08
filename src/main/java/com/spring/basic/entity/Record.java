package com.spring.basic.entity;

import jakarta.persistence.Entity;

@Entity
public class Record {

	private int id;
	private String recordName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecordName() {
		return recordName;
	}
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	
}
