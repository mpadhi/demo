package com.example.consumer.dto;

/*import org.springframework.stereotype.Component;

@Component*/
public class Response {
	
	private String name;
	private String dept;
	
	
	public Response(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
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
	
	

}
