package com.example.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserData")
public class UserData {
	
	@Id
	private long id;
	private String name;
	private String dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public UserData(long id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	public UserData() {
		super();
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}
	
	
	

}
