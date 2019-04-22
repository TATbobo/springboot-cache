package com.tucker.springbootcache.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
	
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender; //性别 1男  0女
	private Integer d_id;
	
	
	public Employee() {
		super();
	}

	
	public Employee(Integer id, String lastName, String email, Integer gender, Integer d_id) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.d_id = d_id;
	}


}
